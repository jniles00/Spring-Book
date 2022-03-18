# Spring-Book

## Why are we doing this?
The purpose of this project was to demonstrate all the skills and tools we have acquired whilst on this bootcamp. This included:

Agile methodology – being able to work in an interative style. Working on features, testing them and then pushing them to the main code when completed. 

Jira – using a scrum board that kept track of tasks.

Git – used for version control and project management.

Java – object orientated proramming language that was used to create the back end for the API.

Postman – used to call functions from the API.

H2 – a database that was used to store the information from the back end.

Created along with these were a Risk Assessment that identified any pontential risks and ways to mitigate them. And a MoSCoW chart (Must Have, Should Have, Could Have, Won’t Have) that displayed what was needed to for an MVP (minimal viable product) and helped keep the project within scope.
## How I expected the challenge to go?
I definitely expected it to be challenging as this was something that I had not fully done before. Some parts came naturally, where as other parts would require a little memory jog by going back and watching the lessons. The back-end part of the project was not so bad. However, the database and testing parts of the project provided to be the most challenging. They were a bit hard to get my head around and involved multiple questions and explanations to get a better understanding. Though I still do not fully understand the topics, my knowledge of them is a lot better now compared to previously.


## What went well/What didn’t go as planned?
Starting with what went well I would say setting up the back-end. This included classes such as the entity, controller, repo and service. This is due to them being a lot more straight forward to do. I also found that even though I would be making mistakes, these were little ones that I would notice and be able to fix myself. Some of these mistakes included forgetting to make a class an interface or not adding extends keyword.
Moving onto what did not go as planned. The testing phase proved to cause some issues. One instance in particular happened when implementing the testUpdate method within the BookControllerIntergrationTest class. Even though the code was written fine and it would run within Postman and update one of the book object’s information and would return the correct status message. However, the test within Eclipse would fail and it would return the same book information. It got so bad that at one point there were two trainers helping to solve it. In the end had to write it out in a different way. I decided to keep the original way in but commented out, so that I can go back to it and possible fix it.


## Possible improvements for future revisions of the project
In terms of what could be done to improve the project for future revisions. Adding a front end would be something I would like to implement. In my current state I do not have the knowledge to complete such a task. However, I would definitely be interested in coming back to try it.
Adding custom queries and custom exceptions is another improvement I would like to add. Whilst we did go over them during the training, I was not too confident in my ability to deliver on those features within the time frame give. Perhaps if more time was given then I would have been able to add them, but that can be something for the future.
Having some form of security would have been a good addition. Much like the front end situation, I do not have the knowledge to implement such a thing. But can be something to look into once I have the skills.


## Links
[Jira Board](https://jorden00.atlassian.net/jira/software/projects/STP/boards/2/roadmap) \n
The user stories within the Jira board are marked out of 5. With 1 being the lowest/easiest and 5 being the highest/hardest.

## Screenshots
### Intergration and Unit Tests
#### Book Controller Unit Test
![Book Controller Unit Test screenshot](https://github.com/jniles00/Spring-Book/blob/dev/Screenshots/Test/Book%20Controller%20Test%20Unit.png)

#### Book Intergration Test
![Book Intergration Test sceenshot](https://github.com/jniles00/Spring-Book/blob/dev/Screenshots/Test/Book%20Integration%20Test%20Results.png)

#### Book Service Unit Test
![Book Service Unit Test screenshot](https://github.com/jniles00/Spring-Book/blob/dev/Screenshots/Test/Book%20Service%20Unit%20Testing.png)

#### Book Test
![Book Test screenshot](https://github.com/jniles00/Spring-Book/blob/dev/Screenshots/Test/Book%20Test.png)

### Postman
#### Create
![Create screenshot](https://github.com/jniles00/Spring-Book/blob/dev/Screenshots/Postman/Postman%20-%20Create.png)

#### Read All
![Read All screenshot](https://github.com/jniles00/Spring-Book/blob/dev/Screenshots/Postman/Postman%20-%20Read%20All.png)

#### Read By ID
![Read By ID screenshot](https://github.com/jniles00/Spring-Book/blob/dev/Screenshots/Postman/Postman%20-%20Read%20By%20Id.png)

#### Update
![Update screenshot](https://github.com/jniles00/Spring-Book/blob/dev/Screenshots/Postman/Postman%20-%20Update.png)

### Database
#### H2 Database before storing books
![H2 Database before storing books screenshot](https://github.com/jniles00/Spring-Book/blob/dev/Screenshots/Database/h2-console%20screenshot_1.png)

#### H2 Database after storing books
![H2 Database after storing books](https://github.com/jniles00/Spring-Book/blob/dev/Screenshots/Database/h2-console%20screenshot_2.png)
