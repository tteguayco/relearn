# Relearn [![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=102)]() [![Open Source Love](https://badges.frapsoft.com/os/gpl/gpl.svg?v=102)](https://opensource.org/licenses/GPL-3.0/)

## What is it?

**Relearn** is a software tool thought to help students when they are starting to learn Relational Algebra, which is a relational query language proposed by Edgar F. Codd in his 1970 paper called "A Relational Model of Data for Large Shared Data Banks".

This project has actually emerged as a web version of the existing [JITRAX](https://github.com/tteguayco/JITRAX), which was a end-of-degree project carried out in La Laguna University in the academic year 2016/17.

## Features

* Execution of complex Relational Algebra queries (see the table below).
* Translation of Relational Algebra queries into SQL equivalent statements.
* Easy specification for the database you are working with: from file or GUI.
* Detection and explanation of both syntax and semantic errors when executing queries.
* Exportation of queries and database specifications to files.

## Relational Algebra operators

| Operator          | Syntax                                               | Example                               |
|-------------------|------------------------------------------------------|---------------------------------------|
| PROJECTION        |  *PROJECT (attrlist) (expression);*                  | `PROJECT A, B (R);`                   |
| SELECTION         |  *SELECT [condlist] (expression);*                   | `SELECT [(A < 1) AND (B = 'b')] (R);` |
| RENAME            |  *RENAME attrlist (expression);*                     | `RENAME C, D (R);`                    |
| CARTESIAN PRODUCT |  *expression x expression;*                          | `R x S;`                              |
| UNION             |  *expression UNION expression;*                      | `R UNION S;`                          |
| DIFFERENCE        |  *expression - expression;*                          | `R - S;`                              |
| INTERSECTION      |  *expression INTERSECT expression;*                  | `R INTERSECT S;`                      |
| NATURAL JOIN      |  *expression * expression;*                          | `R * S;`                              |
| DIVISION          |  *expression / expression;*                          | `R / S;`                              |
| JOIN              |  *expression JOIN expression [condlist]*             | `R JOIN S [R.A = S.A];`               |
| LEFT OUTER JOIN   |  *expression LEFT OUTER JOIN expression [condlist]*  | `R LEFT OUTER JOIN S [R.A = S.A];`    |
| RIGHT OUTER JOIN  |  *expression RIGHT OUTER JOIN expression [condlist]* | `R RIGHT JOIN S [R.A = S.A];`         |
| FULL OUTER JOIN   |  *expression FULL OUTER JOIN expression [condlist]*  | `R FULL OUTER JOIN S [R.A = S.A];`    |

## Documentation

There is a user guide containing usages and examples available [here](https://relearn.gitbook.io/relearn/). Furthermore, it is expected to generate some useful documentation for developers in the future.

## How to contribute

Do you want to collaborate? We will really appreciate that!

* If you detect any error while using the app which should be fixed, you can open a new issue on GitHub to let the contributors know about it. Please, give as many details about the incidence as you can: screenshots, steps to reproduce the error, etc.

* You may also want to make improvements on the app on your own or to contribute by adding new functionality. If so, you can clone the project's repo, make all the changes you want in a new branch and then send them through a Pull Request to be reviewed by the contributors. You can find further information about GitHub's Pull Requests [here](https://help.github.com/articles/about-pull-requests/).

## Heroku deploy

The app is currently running on a domain thanks to [Heroku](https://dashboard.heroku.com/) :-)

Check it out here: https://relearn-ull.herokuapp.com/

## Authors

The authors of this project are Jesús Manuel Jorge Santiso and Teguayco Gutiérrez González, professor and former student of La Laguna University, respectively. 

## Screenshots

![database](https://user-images.githubusercontent.com/20015750/46258262-ac1e4100-c4c7-11e8-9289-0307b4d6af11.png)
![database1](https://user-images.githubusercontent.com/20015750/46258263-ac1e4100-c4c7-11e8-8574-39106c764283.png)
![query_execution](https://user-images.githubusercontent.com/20015750/46258261-ac1e4100-c4c7-11e8-9a20-afef6f809a94.png)