package com.sgcib.training.bdd.ugly;

import com.sgcib.training.bdd.FunkyExotic;
import cucumber.api.Format;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Currency;
import java.util.Date;

public class NegociationStepDefs {

    private FunkyExotic funckyExoctic;

    @Given("^an FUNKY_EXOTIC$")
    public void an_FUNKY_EXOTIC() throws Throwable {
        funckyExoctic = new FunkyExotic();
    }

    @Given("^deal way is \"([^\"]*)\"$")
    public void deal_way_is_sell(String dealWay) throws Throwable {
       this.funckyExoctic.setDealWay(dealWay);
    }

    @Given("^deal nature is \"([^\"]*)\"$")
    public void deal_nature_is(String nature) throws Throwable {
        this.funckyExoctic.setDealNature(nature);

    }

    @Given("^trade value date is \"(.*)\"$")
    public void trade_value_date_is(@Format("yyyy/MM/dd") Date tradeValueDate) throws Throwable {
        this.funckyExoctic.setDate(tradeValueDate);
    }

    @Given("^nominal is (\\d+) \"([^\"]*)\"$")
    public void nominal_is(int nonimal,String currencyCode) throws Throwable {
        Currency japan = Currency.getInstance(currencyCode);
        this.funckyExoctic.setNominal(nonimal,japan);
    }

    @Given("^negociation price is (.+) \"([^\"]*)\"$")
    public void negociation_price_is(double negociationPrice, String currencyCode) throws Throwable {
        Currency japan = Currency.getInstance(currencyCode);
        this.funckyExoctic.setNegociationPrice(negociationPrice, japan);
    }

    @When("^I validate the deal$")
    public void I_validate_the_deal() throws Throwable {
        this.funckyExoctic.validate();
    }

    @Then("^there are (\\d+) Price cashflows$")
    public void there_are_Price_cashflows(int price) throws Throwable {
        Assert.assertEquals(price,this.funckyExoctic.getPriceCashfFlow());
    }

    @Then("^there are (\\d+) fee cashflows$")
    public void there_are_fee_cashflows(int fee) throws Throwable {
        Assert.assertEquals(fee,this.funckyExoctic.getFeeCashfFlow());
    }

    @When("^I change the negotiation price to (.+) \"([^\"]*)\"$")
    public void I_change_the_negotiation_price_to(double negociationPrice, String currencyCode) throws Throwable {
        Currency japan = Currency.getInstance(currencyCode);
        this.funckyExoctic.setNegociationPrice(negociationPrice, japan);
    }

    @Then("^the trade cashflow's payment date is \"(.*)\"$")
    public void the_trade_cashflow_s_payment_date_is_(@Format("yyyy/MM/dd") Date tradeValueDate) throws Throwable {
        Assert.assertEquals(tradeValueDate,this.funckyExoctic.getDate());
    }

    @Then("^the trade cashflow's way is \"([^\"]*)\"$")
    public void the_trade_cashflow_s_way_is(String way) throws Throwable {
        Assert.assertEquals(way,this.funckyExoctic.getCashFlowWay());
    }

    @Then("^the trade cashflow's amount is (\\d+) \"([^\"]*)\"$")
    public void the_trade_cashflow_s_amount_is(int amount, String currencyCode) throws Throwable {
        Assert.assertEquals(amount,this.funckyExoctic.getAmout());
    }

    @Then("^the fee cashflow's payment date is \"(.*)\"$")
    public void the_fee_cashflow_s_payment_date_is(@Format("yyyy/MM/dd") Date tradeValueDate) throws Throwable {
        Assert.assertEquals(tradeValueDate,this.funckyExoctic.getDate());

    }

    @Then("^the fee cashflow's way is \"([^\"]*)\"$")
    public void the_fee_cashflow_s_way_is(String feeCashFlowWay) throws Throwable {
        Assert.assertEquals(feeCashFlowWay,this.funckyExoctic.getFeeCashfFlowWay());
    }

    @Then("^the fee cashflow's amount is (\\d+) \"([^\"]*)\"$")
    public void the_fee_cashflow_s_amount_is(int amount, String currencyCode) throws Throwable {
        Assert.assertEquals(amount,this.funckyExoctic.getFeeAmount());
    }
}
