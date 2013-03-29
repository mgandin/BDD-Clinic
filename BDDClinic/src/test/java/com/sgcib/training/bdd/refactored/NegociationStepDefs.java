package com.sgcib.training.bdd.refactored;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.PendingException;

public class NegociationStepDefs {
    @Given("^a sell for a nominal (\\d+) \"([^\"]*)\" on FUNKY_EXOTIC \"([^\"]*)\" negotiation price (\\d+).(\\d+) \"([^\"]*)\" traded on \"([^\"]*)\"$")
    public void a_sell_for_a_nominal_on_FUNKY_EXOTIC_negotiation_price_traded_on(int arg1, String arg2, String arg3, int arg4, int arg5, String arg6, String arg7) throws Throwable {
        throw new PendingException();
    }

    @When("^the middle officer validates the deal$")
    public void the_middle_officer_validates_the_deal() throws Throwable {
        throw new PendingException();
    }

    @Then("^the trade has one Price cashflow and no fee cashflow$")
    public void the_trade_has_one_Price_cashflow_and_no_fee_cashflow() throws Throwable {
        throw new PendingException();
    }

    @When("^the middle officer changes the negotiation price to -(\\d+).(\\d+) \"([^\"]*)\"$")
    public void the_middle_officer_changes_the_negotiation_price_to_(int arg1, int arg2, String arg3) throws Throwable {
        throw new PendingException();
    }

    @When("^validates the deal$")
    public void validates_the_deal() throws Throwable {
        throw new PendingException();
    }

    @Then("^the trade has the following cashflows:$")
    public void the_trade_has_the_following_cashflows(DataTable arg1) throws Throwable {
        throw new PendingException();
    }

}
