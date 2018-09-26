Made all hw5 changes to the sarec.railwaycrossing package.

Reflections
===========

1. The major design change that I made was to add more logic into the Car's move method.
I added the concept of a lead car in the x direction and allowed cars to move horizontally
by adding an x speed. When a car changes direction it also changes the "direction" that it looks
for lead cars. In addition, I added random number generation to decided when to change roads.
I liked that my design kept most of the concepts from the initial code. It made it easy to integrate
the new logic with the old. One drawback to my approach is that adding more roads would probably be difficult.
If it had needed to be more scalable I probably would have attempted a design that built out a more comprehensive
concept of which roads contained which cars. As is I think it compromised fairly well to meet the requirements.

2. I do not think my current design would scale very well. Currently the move logic uses pixel locations to determine where
on the map the cars are, and also where they should be heading. If we wanted to add many more roads to the map, it would take
a lot of extra logic to have cars make decisions based on the new road locations. I do think that the concept of a "lead car"
is a good one and should be kept for both directions. If I wanted to scale my design I would separate out the car routing
code from the move code and integrate it with the roads.