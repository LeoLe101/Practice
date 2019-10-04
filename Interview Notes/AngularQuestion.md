# ANGULAR INTERVIEW NOTE
## Interview Questions for Angular
1. What is Angular Framework?
    - Angular is a TypeScript based open-source front-end platform that makes it easy to build web-applications with in web/mobile/desktop. The major features of this framework such as *__declarative templates__*, __*dependency injection*__, *__end to end tooling__*, and many more other features are used to ease the development.

1. What is the difference between AngularJS and Angular?
    - AngularJS and Angular are 2 different framework with the same name.
    - __Angular__: is more ready for the current state of web standards and the future state of the web (ES6-7, Immutiablity, components, shadow DOM, service workers, mobile compatibility, modules, typescript...)
    - __AngularJS__'s features such as controllers, $scope, directives (are replaced with `@component`), module definition, and etc are changed.
    - __Angular__ or newer version also has *CLI*
    - __Angular__ use TypeScript help with data type and initialization of variable. It also compile at run-time instead of in the browser like Javascript.
    - __AngularJS__ has to bind with HTML for directive to work. `$scope` and `$rootScope` have been deprecated.

1. Angular component lifecycle hooks
    - After creating a component/directive in constructor, Angular calls the lifecycle hook as Angular create, updates, and destroys them.

    - `ngOnChanges()`: Called __*Before*__ `ngOnInit()` and __*Whenever*__ on of the data-bound input properties change. Response when Angular (re)sets data-bound input properties.

    - `ngOnInit()`: Called __*Once*__ after the first `ngOnChanges()`. Initialize directives/components after Angular first displays the data-bound properties and set those input properties.

    - `ngDoCheck()`: Called __*During every change*__ detection run, immedieatly after `ngOnChanges()` and `ngOnInit()`.

    - `ngAfterContentInit()`: Called __*Once*__ after the first `ngDoCheck()`. Responsd after Angular projects external content into the component's view or the view that a directive is in.

    - `ngAterContentChecked()`: Called __*After*__ the `ngAfterContentInit()` and __*Every Subsequent*__ `ngDoCheck()`. Respond after Angular checked the content projected into the directive/component.

    - `ngAterViewInit()`: Called __*Once*__ after the first `ngAfterContentChecked()`. Respond after Angular initializes the component's views and child views or the view that directive is in.

    - `ngAterViewChecked()`: Called  __*After*__ the `ngAterViewInit()` and __*Every Subsequent*__ `ngAterContentChecked()`. Respond after Angular checks the component's views and child views or the view that a directive is in.

    - `ngOnDestroy()`: Called __*Just Before*__ Angular destroys the directive/component. Cleanup, __unsubscrie__ Observables and __detach__ event handlers to avoid *memory leaks*.

1. Template driven vs Reactive forms
    - __Template Driven__: Define a form in template that such as `[(ngModel)]`, `ngSubmit`. Can have 2-way data binding through `[(ngModel)]` directive and required to have the `name` attribute to defin what kind of inputs that is. Do not required to create or initialize anywhere in logic code.

    - __Reactive Form__: Required to be initialized in the application through `new FormGroup()` or `new FormControl()`. Reactive form has more control over what kind of input is being entered and can easily setup `Validators` such as Regex or Required flag. By using this, required to use `[formGroup]` and `formControlName` directive. (__NOTE__: need to be imported into the application before use, usually app.component.ts. __No need__ to define *template variables* and implement *form validation* or *data binding* in the HTML file comparing to __Template Driven__).

1. What is a __Module__?
    - Modules are logical boundaries in your application; the application is divided into different modules to separate the functionality of your application. The NgModule decorator has three options:
        - The `imports` option is used to import other dependent modules. The `BrowserModule` is required by default for any web-based Angular application
        - The `declarations` option is used to define components, directives, pipe, or services in the respective module
        - The `bootstrap` option tells Angular which is the root component of this Module to bootstrap in the application

## RxJS Library
1. 

## JavaScript
1. What is the difference between `let`, `const`, and `var`
    - `Let`: Block Scope
    - `Const`: Block Scope, but READ ONLY
    - `Var`: Function Scope

1. Does JavaScript pass by value or pass by reference?
    - Pass by __Reference__. Shallow copy that will modify the original data.

1. ES6 operators? [__Reference__] (https://medium.com/poka-techblog/simplify-your-javascript-use-map-reduce-and-filter-bd02c593cc2d)
    - `.map()`: a Mapping functions takes 2 arguments, a callback and an optional context(will be considered as `this` in the callback). Callback runs for each value in the array and returns each new value in the resulting aray. AKA create a new array with the results from callback.
    - `.split()`: a methods to separate string into substrings with specific characters/Regex for each split.
    - `.reduce()`: Similar to `.map()`, use callback for each element of an array. But it passes the result of the callback from one array element to another. So instead of returning the value back to the array, it return it to the next callback.
    - `.tap()`:
    _ `.filter()`: Similar to `.map()` but filter to specific result in the callback. Only the result that is returning __true__ will be in the array. Otherwise, it will be skipped.
Example: 
```javascript
const totalJediScore = personnel
  .filter(person => person.isForceUser)
  .map(jedi => jedi.pilotingScore + jedi.shootingScore)
  .reduce((acc, score) => acc + score, 0);
```

## How to Debug an Angular application:
1. __Angular__
    - TypeScript help with data type and initialization of variable. It also compile at run-time instead of in the browser like Javascript.

    - Debugger Statement
    - Chrome Browser Developer Tool

1. __AngularJS__
    - `$scope` from the element by using `scope()`: `var scope = ele.scope();`
    - Contrller of an element can be fetched using `controller()`
    - Debuger Statement
    - Chrome Browser Developer Tool

## 3 Steps to process for handling code assignments
1. Solve it conceptually
    - First with a simple input.
    - Second with a more complex input.
1. Solve it with pseudo code
1. Solve it with real code
1. Forget all about what you know. At this point, just try to use what you already know with the dedicated input value and some assumption of the output of what your pseudo-code will produce and continue doing these steps.

## The interview usually have question about OOP
1. Implementation of inheritance in that kind of language.
1. JavaScript specific implementation of Prototype inheritance.
