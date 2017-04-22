% Author: Dillon Harless
% Date: 4.11.2017
% This program asks the user a series of questions
% in order to determine the thing that the user
% is thinking of.


% The thing must be from th list below. This list pairs the thing with
% its type.

type(rabbit,animal).
type(dog,animal).
type(snake,animal).
type(fish,animal).
type(whale,animal).
type(t_rex,animal).   % I changed dinosaur to t_rex in order to differentiate from raptor
type(lion,animal).
type(horse,animal).
type(chicken,animal).
type(shark,animal).
type(eagle,animal).
type(ant,animal).
type(starfish,animal).
type(raptor,animal).
type(carrot,plant).
type(orange,plant).
type(seaweed,plant).
type(coral,plant).
type(rose,plant).
type(computer,object).
type(car,object).
type(boat,object).
type(submarine,object).
type(pencil,object).

alive(rabbit).
alive(dog).
alive(snake).
alive(fish).
alive(whale).
alive(eagle).
alive(lion).
alive(horse).
alive(chicken).
alive(shark).
alive(ant).
alive(starfish).
alive(carrot).
alive(orange).
alive(seaweed).
alive(coral).
alive(rose).
%General categories for animal.

mammal(rabbit).
mammal(dog).
mammal(whale).
mammal(lion).
mammal(horse).

reptile(snake).
reptile(t_rex).
reptile(raptor).

fish(fish).
fish(shark).


bird(chicken).
bird(eagle).

insect(ant).

%General categories for plants.

vegetable(carrot).
vegetable(seaweed).
fruit(orange).
flower(rose).

%General environment

water(fish).
water(whale).
water(shark).
water(starfish).
water(seaweed).
water(boat).
water(submarine).
land(rabbit).
land(dog).
land(snake).
land(t_rex).
land(lion).
land(horse).
land(chicken).
land(ant).
land(raptor).
land(carrot).
land(orange).
land(rose).
land(computer).
land(car).
land(pencil).
air(eagle).


%General use for objects

software(computer).
transportation(car).
transportation(boat).
transportation(submarine).
writing(pencil).


%If it's an object this defines submarine
submersible(submarine).

%If animal, do humans ride it?
ridden(horse).

%Tells whether or not Americans eat it regularly.

eaten(rabbit).
eaten(fish).
eaten(chicken).
eaten(carrot).
eaten(orange).
eaten(seaweed).

%Tells whether it is a house pet. Only needeed dog to separate from Lion

housePet(dog).

%Tells if it has teeth. For shark and starfish.
teeth(shark).

% Tells if thing is larger than a bus for differentiation between t_rex
% and raptor.
large(t_rex).

% guess(Thing) remains highlighted red because it is in fact not called
% until the user calls it. Then, it begins asking the questions below.
% Based on the input, the questions will slightly differ as the AI
% begins to narrow down the categories. When it narrows it down to one
% object, it guesses!

guess(Thing) :- ask_type(Type),

    ((Type==animal; Type==plant)->ask_alive(Life);Life=dead),
    ((Life==alive; Life==dead)->ask_environment(Env);Env=none),
    ((Type==object)->ask_use(Use);Use=none),
    ((Type==object)->ask_submersible(Submersible);Submersible=no),
    ((Type==animal,Life==alive,Env==land)->ask_ridden(Ridden);Ridden=no),
    ((Type==animal)->ask_animalCategory(AnimalCategory);AnimalCategory=none),
    ((Type==plant)->ask_plantCategory(PlantCategory);PlantCategory=none),
    (((Type==plant;Type==animal),Life==alive)->ask_eaten(Eaten);Eaten=no),
    ((Type==animal,Life==alive,Env==land,Ridden==no,AnimalCategory==mammal,Eaten==no)->ask_housePet(HousePet);HousePet=no),
    ((Type==animal,Life==alive,Env==water,Ridden==no,AnimalCategory==fish,Eaten==no)->ask_teeth(Teeth);Teeth=no),
    ((Type==animal,Life==dead)->ask_large(Large);Large=no),


    report(Thing,Type,Life,Env,Use,Submersible,Ridden,AnimalCategory,PlantCategory,Eaten,HousePet,Teeth,Large).

% These are all the possible questions that the AI can ask.

ask_type(Type) :- writef("Is it an animal, plant, or object? \n"), read(Type).
ask_alive(Life) :- writef("Is it alive or dead? \n"), read(Life).
ask_environment(Env) :- writef("In what environment is it found? Enter water, land, or air. \n"), read(Env).
ask_use(Use) :- writef("What is its purpose? Enter software, transportation, or writing. \n"), read(Use).
ask_submersible(Submersible) :- writef("Can it be completely submerged? Enter yes or no. \n"), read(Submersible).
ask_animalCategory(AnimalCategory) :- writef("Is it a mammal, reptile, fish, bird, insect, or none of these? \n"), read(AnimalCategory).
ask_ridden(Ridden) :- writef("Is it commonly ridden by humans? Enter yes or no. \n"), read(Ridden).
ask_plantCategory(PlantCategory) :- writef("Is it a fruit, vegetable, or flower? \n"), read(PlantCategory).
ask_eaten(Eaten) :-  writef("Is it both easily available to eat and commonly eaten in the U.S.? Enter yes or no. \n"), read(Eaten).
ask_housePet(HousePet) :- writef("Is it a common house pet? Enter yes or no. \n"), read(HousePet).
ask_teeth(Teeth) :- writef("Does it have teeth? Enter yes or no. \n"), read(Teeth).
ask_large(Large) :- writef("Is it larger than a bus? \n"), read(Large).


% These are the relations that the AI uses for determining objects types
% and categories.
%
report(Thing,Type,Life,Env,Use,Submersible,Ridden,AnimalCategory,PlantCategory,Eaten, HousePet,Teeth,Large) :-
    type(Thing, Type),
    ((Life==alive)->alive(Thing);not(alive(Thing))),
    ((Env==water)->water(Thing);not(water(Thing))),
    ((Env==land)->land(Thing);not(land(Thing))),
    ((Env==air)->air(Thing);not(air(Thing))),
    ((Use==software)->software(Thing);not(software(Thing))),
    ((Use==transportation)->transportation(Thing);not(transportation(Thing))),
    ((Use==writing)->writing(Thing);not(writing(Thing))),
    ((Submersible==yes)->submersible(Thing);not(submersible(Thing))),
    ((AnimalCategory==mammal)->mammal(Thing);not(mammal(Thing))),
    ((AnimalCategory==reptile)->reptile(Thing);not(reptile(Thing))),
    ((AnimalCategory==fish)->fish(Thing);not(fish(Thing))),
    ((AnimalCategory==bird)->bird(Thing);not(bird(Thing))),
    ((AnimalCategory==insect)->insect(Thing);not(insect(Thing))),
    ((Ridden==yes)->ridden(Thing);not(ridden(Thing))),
    ((PlantCategory==fruit)->fruit(Thing);not(fruit(Thing))),
    ((PlantCategory==vegetable)->vegetable(Thing);not(vegetable(Thing))),
    ((PlantCategory==flower)->flower(Thing);not(flower(Thing))),
    ((Eaten==yes)->eaten(Thing);not(eaten(Thing))),
    ((HousePet==yes)->housePet(Thing);not(housePet(Thing))),
    ((Teeth==yes)->teeth(Thing);not(teeth(Thing))),
    ((Large==yes)->large(Thing);not(large(Thing))).


