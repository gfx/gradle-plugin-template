# A Template Project For Gradle Plugin [![Build Status](https://travis-ci.org/gfx/gradle-plugin-template.svg)](https://travis-ci.org/gfx/gradle-plugin-template)

```
plugin/   - The main module of a Gradle plugin
example/  - An example android application that uses this plugin
buildSrc/ - A helper module to use this plugin in example modules
```

# Gradle Properties

Copy `gradle.properties.sample` into `~/.gradle/gradle.properties` and set correct values.

Note that `PGP_KEY_ID` is the value that `gpg --list-secret-keys` shows.

# Author And License

Copyright 2014, FUJI Goro (gfx) <gfuji@cpan.org>. All rights reserved.

This library may be copied only under the terms of the Apache License 2.0, which may be found in the distribution.
