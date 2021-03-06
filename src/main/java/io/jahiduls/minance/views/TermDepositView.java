package io.jahiduls.minance.views;

import io.jahiduls.minance.aggregates.TermDepositAggregate;
import io.jahiduls.minance.models.Amount;
import io.jahiduls.minance.models.Date;
import io.jahiduls.minance.models.InterestRate;
import io.jahiduls.minance.models.InvestmentPeriod;
import io.jahiduls.minance.models.MaturityInstruction;
import io.jahiduls.minance.models.User;
import java.util.UUID;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@ToString
@EqualsAndHashCode
public class TermDepositView {
    public final UUID id;
    public final User user;
    public final Date createdOn;
    public final String depositor;
    public final Amount amount;
    public final InvestmentPeriod period;
    public final InterestRate interestRate;
    public final MaturityInstruction maturityInstruction;

    public static TermDepositView from(TermDepositAggregate aggregate) {
        return TermDepositView.builder()
                .id(aggregate.getUuid())
                .user(aggregate.getUser())
                .createdOn(aggregate.getCreatedOn())
                .depositor(aggregate.getDepositor())
                .amount(aggregate.getAmount())
                .period(aggregate.getPeriod())
                .interestRate(aggregate.getInterestRate())
                .maturityInstruction(aggregate.getMaturityInstruction())
                .build();
    }
}
