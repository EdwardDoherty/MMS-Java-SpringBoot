### Services: 
The "Services" folder contains classes that encapsulate the business logic of the application. Services provide a layer 
of abstraction between the controllers and repositories, handling complex operations, processing data, and enforcing 
business rules.

### Interesting Tidbits:
"The Service layer is in charge of mapping DTO's into entities and viceversa."

### Notes:
So ***THIS*** is where all the magic happens. All the algorithms, functionality, etc. etc. etc. This is where all the real 
work is being done. The vast majority of the code I am rewriting from the original project will go here.

Services will be split up into their own individual folders.

#### Service Order of Operations:
1. Service method is called by the controller
2. Service executes method, *using* model objects to do things (like calculate an expense total from the Expense objects)
3. Service sends data back to the controller in the form of a DTO

### Planned Services:

#### Expense Sheet:
View/Add/Edit expenses according to their due dates. View/Add/Edit extra information for liabilities (debts).

#### Dashboard:
Give the user some useful quick information when they first log in. Quickly check their financial situation using the 
most useful information to their day-to-day.

#### Debt Strategy:
Use interest rate, total balance, and monthly cost to determine the "Impact Ratio", the ratio of total balance to
monthly cost. A credit card with a balance of $100 and a monthly payment of $50 will have an impact ratio of 0.5. This 
tells the user that, for a given dollar amount, paying off a debt with a higher impact ratio will have a higher impact 
on their monthly costs, which is often the more important metric for people. Eventually, the Debt Strategy service will 
make recommendations for early payoff, debt consolidation, refinancing, and more.

#### Expense Strategy:
The program will calculate predictions of future financial situations, and make suggestions on how to handle them. For 
example:

    It looks like you're going to be short this month!
    Your power bill has a grace period of 30 days, if you pay this with your next paycheck,
    you won't pay a fee and you'll have the extra cash to afford it then.
Or

    It looks like rent is coming up!
    Save $1000 from this paycheck to smooth out your cashflow!



#### Login / Multiple Users:
Allow multiple users on the site. The can log into their accounts, and their information will be saved for future visits
to the site.

#### Notifications: 
Send notifications through text, email, discord, browser, etc.
