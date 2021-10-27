# Simple Rule Engine

This is the assignment to develop a solution that allows the business to dynamically generating product pricing from a 
set rules defined by the finance team.

Initial Rules:

 1 - All products start at 5.0 interest_rate.
 
 2 - If the person lives in Florida (condition), we do not offer the product to them and the product is
    to be disqualified (action).
 
 3 - If the person has a credit score greater than or equal to 720(condition) then we reduce the
   interest_rate on the product by .3 (action that has an input of “.3”, remember the business may
   decide in the future they want to reduce it by .5).
   
 4 - If the person has a credit score lower than 720 we increase the interest_rate on the product by
     .5. 
     
 5 - If the name of the product is “7-1 ARM” then we need to add .5 to the interest_rate of the
     product. 
     
 6 - Create your own rule definition to execute an additional action on a product.    
        Created Age Qualification rule. If customer is under 25 and over 65, they will be disqualified.
        
       
 SET UP:
 
 This project created with Java 8 and Maven.
 
 Please see rule.json for the list of rules that are provided by finance team.
 
 To run a specific test, use the Runner class in test folder, Also created regression test for this project which 
 is located in test folder as well where 15 test cases included.
 
 To learn more about logic of the rules please go to rules folder and see RulesEngine class.