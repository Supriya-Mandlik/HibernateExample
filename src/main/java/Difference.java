/*
            get() Method                                    load() Method  

1] get() Method of Hibernate session returns     1] load() Method throws ObjectNotFoundException
   null if object is not found in cache as          if object is not found on cache as well as
    well as database.                               on database but never returns null.

2] get() involves database hit if object does    2] load() method can return proxy in place and
   not exists in session cache and returns        only initialize the object or hit the database
   a fully initialized object which may           if any method other than getId() is called on
   involve several database call.                 persistent or entity object.

3] Use if you are not sure that object exists    3] Use if you are sure that object exists.
  in database or not.
*/