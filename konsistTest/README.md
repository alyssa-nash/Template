# Konsist Tests

[Konsist](https://docs.konsist.lemonappdev.com/) is a static analyzer tool that uses unit tests
to verify standardization of the codebase by ensuring adherence to a common set of coding 
conventions, thereby improving the readability and maintainability of the code.

I like the idea of linting such simple best practices, especially if their are junior or entry
level developers on the team. It's a good way to enforce a common style guide and ensure that
everyone is on the same page.

For this project, I've included a few Konsist tests that are important and also can be easily
missed, such as:

1. Use the new JUnit5 API for writing tests, not the old JUnit4 API.
2. Every ViewModel and UseCase class should have a corresponding test class.
3. UseCases should have a single invoke method.