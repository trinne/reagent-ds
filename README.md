# Reagent Design System

Reagent Design System is a library for creating visual Styleguid / Storybook presentation of Reagent components.
This library aims to ease the pain for developing front-end component system together with designers.

### Development mode

To start the Figwheel compiler, navigate to the project folder and run the following command in the terminal:

```
lein figwheel
```

Figwheel will automatically push cljs changes to the browser.
Once Figwheel starts up, you should be able to open the `public/index.html` page in the browser.


### Building for production

```
lein clean
lein package
```
