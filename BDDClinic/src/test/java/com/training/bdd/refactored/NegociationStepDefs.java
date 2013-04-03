package com.training.bdd.refactored;

import com.training.bdd.FunkyExotic;
import cucumber.api.Format;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Currency;
import java.util.Date;
import java.util.List;

public class NegociationStepDefs {
    private FunkyExotic funckyExoctic;

    @Given("^a sell for a nominal (\\d+) \"([^\"]*)\" on FUNKY_EXOTIC \"([^\"]*)\" negotiation price (.+) \"([^\"]*)\" traded on \"(.*)\"$")
    public void a_sell_for_a_nominal_on_FUNKY_EXOTIC_negotiation_price_traded_on(int nominal, String currencyNominal, String nature, int negociationPrice, String currencyNego, @Format("yyyy/MM/dd") Date tradeValueDate) throws Throwable {
        funckyExoctic = new FunkyExotic();
        funckyExoctic.setNominal(nominal,Currency.getInstance(currencyNominal));
        funckyExoctic.setDealNature(nature);
        funckyExoctic.setNegociationPrice(negociationPrice,Currency.getInstance(currencyNego));
        funckyExoctic.setDate(tradeValueDate);
    }

    @When("^the middle officer validates the deal$")
    public void the_middle_officer_validates_the_deal() throws Throwable {
        funckyExoctic.validate();
    }

    @Then("^the trade has (\\d+) Price cashflow and (\\d+) fee cashflow$")
    public void the_trade_has_Price_cashflow_and_fee_cashflow(int price, int fee) throws Throwable {
        Assert.assertEquals(price,funckyExoctic.getPriceCashfFlow());
        Assert.assertEquals(fee,funckyExoctic.getFeeCashfFlow());
    }

    @When("^the middle officer changes the negotiation price to (.+) \"([^\"]*)\"$")
    public void the_middle_officer_changes_the_negotiation_price_to_(double negociationPrice, String currencyCode) throws Throwable {
        Currency japan = Currency.getInstance(currencyCode);
        this.funckyExoctic.setNegociationPrice(negociationPrice, japan);
    }

    @Then("^the trade has the following cashflows:$")
    public void the_trade_has_the_following_cashflows(@Format("yyyy/MM/dd") List<CashFlow> cashFlows) throws Throwable {
        for (CashFlow cashFlow : cashFlows) {
            if(cashFlow.flowType == "Price") {
                Assert.assertEquals(cashFlow.amount,funckyExoctic.getAmout());
                Assert.assertEquals(cashFlow.currency,funckyExoctic.getCurrencyNego().getCurrencyCode());
                Assert.assertEquals(cashFlow.way,funckyExoctic.getCashFlowWay());
                Assert.assertEquals(cashFlow.paymentDate,funckyExoctic.getDate());
            }

            if(cashFlow.flowType == "Fee") {
                Assert.assertEquals(cashFlow.amount,funckyExoctic.getFeeAmount());
                Assert.assertEquals(cashFlow.currency,funckyExoctic.getCurrencyNego().getCurrencyCode());
                Assert.assertEquals(cashFlow.way,funckyExoctic.getFeeCashfFlowWay());
                Assert.assertEquals(cashFlow.paymentDate,funckyExoctic.getDate());
            }
        }
    }

    public class CashFlow {
        public String flowType;
        public String way;
        public int amount;
        public String currency;
        public Date paymentDate;
        public String remarks;
    }
}
