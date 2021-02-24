package io.jahiduls.minance.resources;

import io.jahiduls.minance.model.Amount;
import io.jahiduls.minance.model.InvestmentPeriod;
import io.jahiduls.minance.model.MaturityInstruction;
import lombok.ToString;

/**
 * JSON structure
 *
 * <pre>
 * {
 *     period: {
 *         years: number,
 *         months: number,
 *         days: number,
 *     },
 *     amount: {
 *         rupee: number,
 *         paise: number,
 *         maturityInstruction: PAYOUT_PRINCIPLE_AND_INTEREST | REINVEST_PRINCIPLE_AND_INTEREST | REINVEST_PRINCIPLE_AND_PAYOUT_INTEREST,
 *     }
 * }
 * </pre>
 */
@ToString
public class TermDepositResource {
    public InvestmentPeriod period;
    public Amount amount;
    public MaturityInstruction maturity;
}