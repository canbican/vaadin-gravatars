# MyComponent Add-on for Vaadin 8

Gravatars is a UI component add-on for Vaadin 8.

## Online demo

Try the add-on demo at https://gravatar-vaadin-demo.herokuapp.com

## Download release

Official releases of this add-on are available at Vaadin Directory. For Maven instructions, download and reviews, go to http://vaadin.com/addon/gravatars

## Building and running demo

git clone git@github.com:1dir1/vaadin-gravatars.git
mvn clean install
cd gravatars-demo
mvn jetty:run

To see the demo, navigate to http://localhost:8080/

### Importing project

Choose File > Import... > Existing Maven Projects

Note that Eclipse may give "Plugin execution not covered by lifecycle configuration" errors for pom.xml. Use "Permanently mark goal resources in pom.xml as ignored in Eclipse build" quick-fix to mark these errors as permanently ignored in your project. Do not worry, the project still works fine. 

## Release notes

### Version 0.1
- Initial release

## Roadmap

This component is developed as a hobby with no public roadmap or any guarantees of upcoming releases. That said, if Gravatars change, so should this module.

## Issue tracking

The issues for this add-on are tracked on its github.com page. All bug reports and feature requests are appreciated. 

## Contributions

Contributions are welcome, but there are no guarantees that they are accepted as such. Process for contributing is the following:
- Fork this project
- Create an issue to this project about the contribution (bug or feature) if there is no such issue about it already. Try to keep the scope minimal.
- Develop and test the fix or functionality carefully. Only include minimum amount of code needed to fix the issue.
- Refer to the fixed issue in commit
- Send a pull request for the original project
- Comment on the original issue that you have implemented a fix for it

## License & Author

Add-on is distributed under Apache License 2.0. For license terms, see LICENSE.txt.

Gravatars add-on is written by Can Bican <can@bican.net>

# Developer Guide

## Getting started

See the demo at gravatars-demo/src/main/java/net/birdirbir/vaadin/gravatars/demo/GravatarDemoUI.java

## Features

### Gravatar URL

resource = GravatarResource.builder().build().get("mail.example.com");

### Gravatar Link to Profile Page

resource = GravatarResource.builder().build().getProfile("mail.example.com");
