Feature: Negociation

    Scenario: Fee and Price cashflows when the negotiation price is set to a negative value

        Given a sell for a nominal 100 "JPY" on FUNKY_EXOTIC "TOMATO" negotiation price 0.20 "JPY" traded on "2012/07/01"
        When the middle officer validates the deal
        Then the trade has 1 Price cashflow and 0 fee cashflow
        When the middle officer changes the negotiation price to -0.3 "JPY"
        And the middle officer validates the deal
        Then the trade has the following cashflows:
        | FlowType| Way     | Amount | Currency | PaymentDate | Remarks                 |
        | Price   | Receive | 30     | JPY      | 2012/07/01  | 100 * abs(-0.3) JPY     |
        | Fee     | Give    | 60     | JPY      | 2012/07/01  | 100 * 2 * abs(-0.3) JPY |