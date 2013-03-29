Feature: Negociation screen

    Scenario: Change the negotiation price from positive to negative => soulte cashflow appears and premium cashflow is modified
        Given an FUNKY_EXOTIC
        And deal way is "sell"
        And deal nature is "TOMATO"
        And trade value date is "2012/07/01"
        And nominal is 100 "JPY"
        And negociation price is 0.20 "JPY"
        When I validate the deal
        Then there are 1 Price cashflows
        And there are 0 fee cashflows
        When I change the negotiation price to -0.3 "JPY"
        And I validate the deal
        Then there are 1 Price cashflows
        And there are 1 fee cashflows
        And the trade cashflow's payment date is "2012/07/01"
        And the trade cashflow's way is "receive"
        And the trade cashflow's amount is 30 "JPY"
        And the fee cashflow's payment date is "2012/07/01"
        And the fee cashflow's way is "give"
        And the fee cashflow's amount is 60 "JPY"