# CheckVersion
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Download](https://api.bintray.com/packages/eltoryn7/maven/check-market-version/images/download.svg)](https://bintray.com/eltoryn7/maven/check-market-version/_latestVersion)
</br>To check application's version **Library**

Usage
====

```java
compile 'com.lsh.checkversion:check-market-version:1.0.1'

...
CheckModule module = new CheckModule(context); // Constructor with context.
module.getMarketVer(); // Get an application's market version.
module.getApplicationVer(); // Get an application's package version(current version).
module.isVersionSame(); // Market ver and Current ver equals or not.
```
```kotlin

```
