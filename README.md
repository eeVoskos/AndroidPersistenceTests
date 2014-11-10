### Android Persistence Tests

This project is an attempt to answer the question: _What is the best (fastest, most robust, most feature-rich) data persistence framework for Android?_

#### A little background
I've been using [Cupboard][1] for some time now. It's a great framework for 
simpliyfing data persistence, built on top of SQLite.
However, for a simple application I always wanted to find a rather 
simpler approach, instead of having to setup a database or ContentProvider.
This is why I wanted to start searching what's out there. 
New candidates for persistence are [Realm][2] and [Couchbase][3] _(hopefully more coming soon)_.

### Benchmarks

Preliminary results for 1K, 10K and 100K items (times are in milliseconds):

#### Write

| | 1K | 10K | 100K |
|---|---|---|---|
| Cupboard | 83 | 711 | 4204 |
| Realm | 21 | 131 | 892 |

#### Read

| | 1K | 10K | 100K |
|---|---|---|---|
| Cupboard | 134 | 2136 | 26873 |
| Realm | 114 | 752 | 6892 |

_Tests were performed on a MacBook Pro 2013 using Genymotion Nexus 4 Android 4.4.4 emulator._

#### Comparison
Initial tests indicate that Realm is much faster than Cupboard (SQLite) in writes, but much slower in reads.

[1]: https://bitbucket.org/qbusict/cupboard
[2]: https://github.com/realm/realm-java
[3]: https://github.com/couchbase/couchbase-lite-android
