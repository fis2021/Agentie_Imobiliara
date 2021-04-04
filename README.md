# Agentie_Imobiliara
## General Description
This application aims to help people which are looking for a house.
It offers them the possibility to buy their new home. 
It involves a variety of real estate agents to make this journey more enjoyable.
## Technologies Used
* [Java 15 or 16](https://www.oracle.com/java/technologies/javase-downloads.html)
* [JavaFX](https://openjfx.io/openjfx-docs/) (as GUI)
* [Maven](https://maven.apache.org/) / [Gradle](https://gradle.org/) (as build tools)
* [Nitrite Java](https://www.dizitart.org/nitrite-database.html) (as Database)
## Registration 
The user needs to first register into the application by selecting one of the 2 roles: 
* buyer 
* agent

These roles require a unique username, a password and the basic information like full name and phone number.
## Agent
An agent can add, edit or delete the houses on the market. A house should contain its adress, size, number of rooms and baths, number of floors, and special features.
Also, after logging in, he will see a list of bookings for the current week.
From the list of bookings, the agent can reject or approve a booking , specifying a rejection reason.
## Buyer
A buyer needs to login into the application where he will be able to see a list with all the houses. The list should be searchable by the location.
A logged in buyer can also see the properties of a house, by selecting the house from the list.
Also, logged in customers can book a visit arranged by a real estate agent and  see a history of their previous bookings. 
## Issue Tracking
In order to manage our workflow, we created a Jira instance that can be found [here](https://agent-imobiliara.atlassian.net).
