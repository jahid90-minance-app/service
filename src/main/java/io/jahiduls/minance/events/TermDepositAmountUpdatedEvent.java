package io.jahiduls.minance.events;

import io.jahiduls.minance.models.AmountImpl;
import java.util.UUID;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@ToString
@EqualsAndHashCode
public class TermDepositAmountUpdatedEvent {
    public final UUID id;
    public final AmountImpl amount;
}
