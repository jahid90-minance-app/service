package io.jahiduls.minance.controllers;

import io.jahiduls.minance.commands.CreateTermDepositCommand;
import io.jahiduls.minance.commands.UpdateTermDepositAmountCommand;
import io.jahiduls.minance.commands.UpdateTermDepositDepositorCommand;
import io.jahiduls.minance.commands.UpdateTermDepositInterestRateCommand;
import io.jahiduls.minance.commands.UpdateTermDepositMaturityInstructionCommand;
import io.jahiduls.minance.commands.UpdateTermDepositPeriodCommand;
import io.jahiduls.minance.resources.TermDepositResource;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CommandController {

    private final CommandGateway commandGateway;

    @PostMapping("/deposits/term")
    private void addTermDeposit(@RequestBody TermDepositResource resource) {

        log.debug("Received resource: {}", resource);
        final UUID depositId = UUID.randomUUID();
        // The other commands depend on completion of the first one which creates the aggregate
        // Let's wait for its completion before firing off the remaining commands, else they might not find the aggregate
        commandGateway.sendAndWait(CreateTermDepositCommand.builder().id(depositId).user(resource.user).createdOn(resource.createdOn).build());
        commandGateway.send(UpdateTermDepositDepositorCommand.builder().id(depositId).depositor(resource.depositor).build());
        commandGateway.send(UpdateTermDepositAmountCommand.builder().id(depositId).amount(resource.amount).build());
        commandGateway.send(UpdateTermDepositPeriodCommand.builder().id(depositId).period(resource.period).build());
        commandGateway.send(UpdateTermDepositInterestRateCommand.builder().id(depositId).interestRate(resource.interestRate).build());
        commandGateway.send(UpdateTermDepositMaturityInstructionCommand.builder().id(depositId).maturity(resource.maturity).build());
    }

}
