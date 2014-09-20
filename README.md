# Shopping Cart Billing 

[![Build Status](https://travis-ci.org/sbilello/pam.svg?branch=master)](https://travis-ci.org/sbilello/pam)

-------------------------
Billing of the shopping cart needs to be done applying the discounts on each discounted item. Discounts are determined by the type of the item. 
Grocery items get 7.5% discount, Books get 12% discount. If the total bill amount exceeds 40 euros additional 5% discount is applied on overall total.

Bill should display unit price, discount %, final price and final total and total discount. Final total should be rounded off to nearest 5 cents. Price per unit is given.

Write an application that prints out the receipt details for these shopping baskets.

#### Input
Input 1:
* 1 Pasta 1kg at 4.29
* 1 Book at 10.12

Input 2:
* 1 Coffee 500g at 3.21
* 1 Pasta 1Kg at 4.29
* 1 Cake at 2.35

Input 3:
* 10 Chocolate at 2.1
* 1 Wine at 10.5
* 1 Book at 15.05
* 5 Apple at 0.5

#### Output 
Output 1:

| Item | Quantity | UnitPrice | Discount | Final Price |
|:-----|:--------:|:---------:|---------:|------------:|
| Pasta 1kg | 1 | 4.29 | 7.5% | 3.97 |
| Book | 1 | 10.12 | 12% | 8.91 |
| **Total** | | | | 12.90 |
| *Total discounts* | | | | *1.54* |

Output 2:

| Item | Quantity | UnitPrice | Discount | Final Price |
|:-----|:--------:|:---------:|---------:|------------:|
| Coffee 500g | 1 | 3.21 | 7.5% | 2.97 |
| Pasta 1kg | 1 | 4.29 | 7.5% | 3.97 |
| Cake | 1 | 2.35 | 0% | 2.35 |
| **Total** | | | | 9.30 |
| *Total discounts* | | | | *0.56* |

Output 3:

| Item | Quantity | UnitPrice | Discount | Final Price |
|:-----|:--------:|:---------:|---------:|------------:|
| Chocolate | 10 | 2.10 | 0% | 21.00 |
| Wine | 1 | 10.5 | 0% | 10.50 |
| Book | 1 | 15.05 | 12% | 13.24 |
| Apple | 5 | 0.5 | 0% | 2.50 |
| *Gross Total* | | | | 47.24 |
| Volume Discount | | | 5% | 2.36 |
| **Total** | | | | 44.90 |
| *Total discounts* | | | | *4.17* |


You can create the jar project by typing:

`mvn package` 

and execute the application by command line `java -jar pam.jar`
