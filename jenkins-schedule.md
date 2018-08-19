Jenkins introduced a value H.

This field follows the syntax of cron (with minor differences). Specifically, each line consists of 5 fields separated by TAB or whitespace:

MINUTE HOUR DOM MONTH DOW

MINUTE Minutes within the hour (0–59)
HOUR The hour of the day (0–23)
DOM The day of the month (1–31)
MONTH The month (1–12)
DOW The day of the week (0–7) where 0 and 7 are Sunday.
To specify multiple values for one field, the following operators are available. In the order of precedence,

* specifies all valid values
M-N specifies a range of values
M-N/X or */X steps by intervals of X through the specified range or whole valid range
A,B,...,Z enumerates multiple values
To allow periodically scheduled tasks to produce even load on the system, the symbol H (for “hash”) should be used wherever possible. For example, using 0 0 * * * for a dozen daily jobs will cause a large spike at midnight. In contrast, using H H * * * would still execute each job once a day, but not all at the same time, better using limited resources.

The H symbol can be used with a range. For example, H H(0-7) * * * means some time between 12:00 AM (midnight) to 7:59 AM. You can also use step intervals with H, with or without ranges.

The H symbol can be thought of as a random value over a range, but it actually is a hash of the job name, not a random function, so that the value remains stable for any given project.

Beware that for the day of month field, short cycles such as */3 or H/3 will not work consistently near the end of most months, due to variable month lengths. For example, */3 will run on the 1st, 4th, …31st days of a long month, then again the next day of the next month. Hashes are always chosen in the 1-28 range, so H/3 will produce a gap between runs of between 3 and 6 days at the end of a month. (Longer cycles will also have inconsistent lengths but the effect may be relatively less noticeable.)

So the correct answer for building once an hour is

H * * * *
for every 3 hours

H H/3 * * *
The difference between * and H could be also explained as

* translates to EVERY
H translates to ANY
So e.g.

* * * * *
translates to: Build every minute, every hour, every day of month, every month, doesn't matter what day of week it is.

H * * * *
translates to: Build once every hour (x), doesn't matter what exact minute it is (can be any minute between x:00 and x:59)

H H * * *
translates to: Build once every day, doesn't matter what time it is (can be any minute and any hour between 00:00 and 23:59)

The reason why you should prefer using H instead of hardcoded time values is also explained as before

If you have 100 jobs configured with

0 0 * * *
they all will try to start at the same time causing for example a lot of poll and pull traffic at midnight.

If you have them instead all configured with

H H * * *
they all will be built once a day but not all at the same time but distributed over the day. You can than plan the schdedule better by using the time ranges e.g.

H H(18-23) * * *
All jobs will be built every day at any time between 18:00 and 23:59.

It is even also possible to schedule jobs crossing midnight e.g. to build between 19:00pm and 5:00am.

But since cron usually doesn't allow this you can use a trick using a shiftet timezone.

E.g. I'm living in the timezone MEZ which is GMT+1 and I want to build all jobs between 19:00pm and 5:00am. In order to do that I shift my complete timezone by 5 hours using

 TZ=Etc/GMT+6
Than I use a shiftet range for the hours starting at 14:00 (-> +5 = 19:00pm) and ending at 23:59 (-> +5 = 4:59am)

H H(14-23) * * *