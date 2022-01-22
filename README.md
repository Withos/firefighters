# firefighters
Simulates simplified model of distributing of the State Fire Service units on the city of Cracow. 
Using strategy, state, observer and iterator design patterns.

We assume that every one of 7 units has 5 fire trucks in their disposal.
There are 2 types of occurences that can be reported, local threat and fire, both of them have a chance to be a false alarm.
Type of the occurance, time needed for units to get to and back from the occurence, time needed to deal with it and false alarms are generated randomly.
When management of the area gets a report, it notifies all the subordinate units about the occurence. If it's fire, 3 trucks are needed while for the local threat only 2.
We always try to send trucks from the unit closest to the scene, if said unit doesn't have enough trucks we send them from the next closest unit.
