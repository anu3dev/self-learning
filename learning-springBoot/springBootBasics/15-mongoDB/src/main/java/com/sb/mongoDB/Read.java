/*
 * JPARepository extends pagingandsortingRepository extends crudRepository extends Repository
 * MongoRepository extends pagingandsortingRepository extends crudRepository extends Repository 
 *
 * Dependencies =>
 * Spring Data MongoDB
 * Lombok
 * 
 * in mongoDB, data stored in form of JSON.
 *
 * table means collection.
 * data will be stored not in row and column, it will be in documents.
 *   
 * mongod --version --> check mongo DB version.
 * mongosh --version --> check mongo DB shell version.
 * mongosh --> to access mongo DB via CMD.
 * show dbs --> see list of available DB.
 * use learn --> select DB.
 * db.createCollection('employee') --> create collection within DB.
 * show collections --> show list of collection within DB.
 * db.employee.insertOne({id: 1, name: "Anurag"}) --> insert one document to collection.
 * db.employee.find().pretty() --> see inserted document from collection.
 * db.employee.insertMany([{age:34, name: "nitish"},{age:31, name: "seema"}]) --> insert multiple document to collection.
 * db.employee.updateOne({id: 1}, {$set:{name:"anu"}}) --> update one document to collection.
 * db.employee.deleteOne({id: 1}) --> delete one document to collection. 
 */