#!/usr/bin/env bb

(def now (java.time.ZonedDateTime/now))
(def timezone (java.time.ZoneId/of "Asia/Kolkata"))
(def timezone-time (.withZoneSameInstant now timezone))
(def pattern (java.time.format.DateTimeFormatter/ofPattern "HH:mm"))
(println (.format timezone-time pattern))
