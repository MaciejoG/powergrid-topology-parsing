# powergrid-topology-parsing
Creating an embryo of Energy Management System. The project combines Java programming, CIM-XML modelling and parsing, relational databases development and power system analysis

User provides as input to a function: 
-	elementName (f.ex. cim:Substation), 
-	attribute he is interested in f.ex. rdf:ID, (if he doesn’t want any attribute, then he just writes ‘null’)
-	element he is interested in f.ex. cim:IdentifiedObject.name, (if he doesn’t want any element, then he just writes ‘null’)

The function:
1)	finds all the instances of the searched element (f.ex. there are 2 substations)
2)	goes into the first instance
3)	searches for the attribute and returns its value 
4)	searches for the element and returns its name
5)	repeats for other instances
6)	returns an array of attributes and elements for every instance (e.g. every substation)

The class (f.ex. ‘SubstationClass’)
In the class, we define a constructor that has a an ID and a name (as required in the assignment file)

In the main code, we create objects in the ‘SubstationClass’ using the function (so the function will return arrays, which we will use to pass the parameters for our objects)
