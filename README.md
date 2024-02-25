# **Project consists of 3 apis** 

**-API 1:** 
Takes msisdn as a param and adds user to the dials database if he/she does not exist. It also initialize counter to 0 and assign a group to the dial according to a pre-defined logic. 

**-API 2:** 
Takes msisdn as a param checks first if this dial is assigned a group or not, if not "no gift" . Then checks if this group can redeem gifts or not, group(1,2,3) can but group 4 or null can't. Finally it checks if user reached his/her limit for redemption (max 2) if not, it return gift id and gift name. 

**-API 3:** Takes msisdn and gift_id as parameters. It first checks if this id is related to this specific msisdn, if not an error message is printed. Next step, the gift is returned to the user, the counter is incremented by 1, and a log is saved with all user details and date of redemption.

