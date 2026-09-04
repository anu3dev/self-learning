### AWS Database

```
An application is being created that will use Amazon EC2 instances to generate and store data. Another set of EC2 instances will then analyze and modify the data. Storage requirements will be significant and will continue to grow over time. The application architects require a storage solution.

Which actions would meet these needs?


Store the data in an Amazon EFS filesystem. Mount the file system on the application instances

Amazon Elastic File System (Amazon EFS) provides a simple, scalable, fully managed elastic NFS file system for use with AWS Cloud services and on-premises resources. It is built to scale on-demand to petabytes without disrupting applications, growing and shrinking automatically as you add and remove files, eliminating the need to provision and manage capacity to accommodate growth.
```

```
A startup is prototyping a movie streaming platform on AWS. The platform consists of an Application Load Balancer, an Auto Scaling group of Amazon EC2 instances to host the frontend, and an Amazon RDS for PostgreSQL DB instance running in a Single-AZ configuration.

Users report slow response times when browsing the catalog of available movies. The movie catalog is a set of tables in the database that is updated infrequently. A solutions architect finds that the database's CPU utilization spikes significantly during catalog queries.

What should the solutions architect recommend to improve the performance of the platform during catalog searches?

Implement an Amazon ElastiCache for Redis cluster to cache catalog queries. Configure the application to use lazy loading to populate the cache.

ElastiCache provides a highly performant in-memory caching layer that can significantly reduce database load and response times for infrequently updated data like a product or movie catalog. Lazy loading ensures the cache is populated only when a query misses, reducing unnecessary overhead.
```

```
A company runs an application that uses an Amazon RDS PostgreSQL database. The database is currently not encrypted. A Solutions Architect has been instructed that due to new compliance requirements all existing and new data in the database must be encrypted. The database experiences high volumes of changes and no data can be lost.

How can the Solutions Architect enable encryption for the database without incurring any data loss?

Create a snapshot of the existing RDS DB instance. Create an encrypted copy of the snapshot. Create a new RDS DB instance from the encrypted snapshot and update the application. Use AWS DMS to synchronize data between the source and destination RDS DBs.

You cannot change the encryption status of an existing RDS DB instance. Encryption must be specified when creating the RDS DB instance. The best way to encrypt an existing database is to take a snapshot, encrypt a copy of the snapshot and restore the snapshot to a new RDS DB instance. This results in an encrypted database that is a new instance. Applications must be updated to use the new RDS DB endpoint.
```

```
A company uses an Amazon RDS for MySQL instance for its operational database. To handle the increased read-only traffic during a recent peak period, the company added a read replica. During the peak period, the CPU usage on the read replica reached 60%, and the primary instance also had 60% CPU usage. After the peak period ended, the read replica's CPU usage decreased to 25%, while the primary instance consistently remains at 60%. The company wants to optimize costs while ensuring enough capacity for future growth.

Which solution will meet these requirements?

Resize the read replica to a smaller instance size and keep the primary instance unchanged.
```

```
A company uses an Amazon RDS MySQL database instance to store customer order data. The security team have requested that SSL/TLS encryption in transit must be used for encrypting connections to the database from application servers. The data in the database is currently encrypted at rest using an AWS KMS key.

How can a Solutions Architect enable encryption in transit?

Download the AWS-provided root certificates. Use the certificates when connecting to the RDS DB instance.

Amazon RDS creates an SSL certificate and installs the certificate on the DB instance when Amazon RDS provisions the instance. These certificates are signed by a certificate authority. The SSL certificate includes the DB instance endpoint as the Common Name (CN) for the SSL certificate to guard against spoofing attacks.
```

```
A financial services company has a web application with an application tier running in the U.S and Europe. The database tier consists of a MySQL database running on Amazon EC2 in us-west-1. Users are directed to the closest application tier using Route 53 latency-based routing. The users in Europe have reported poor performance when running queries.

Which changes should a Solutions Architect make to the database tier to improve performance?

Migrate the database to an Amazon Aurora global database in MySQL compatibility mode. Configure the application tier in Europe to use the local reader endpoint.

Amazon Aurora Global Database is designed for globally distributed applications, allowing a single Amazon Aurora database to span multiple AWS regions. It replicates your data with no impact on database performance, enables fast local reads with low latency in each region, and provides disaster recovery from region-wide outages.
```

```
An insurance company has a web application that serves users in the United Kingdom and Australia. The application includes a database tier using a MySQL database hosted in eu-west-2. The web tier runs from eu-west-2 and ap-southeast-2. Amazon Route 53 geoproximity routing is used to direct users to the closest web tier. It has been noted that Australian users receive slow response times to queries.

Which changes should be made to the database tier to improve performance?

Migrate the database to an Amazon Aurora global database in MySQL compatibility mode. Configure read replicas in ap-southeast-2
```

```
An eCommerce company runs an application on Amazon EC2 instances in public and private subnets. The web application runs in a public subnet and the database runs in a private subnet. Both the public and private subnets are in a single Availability Zone.

Which combination of steps should a solutions architect take to provide high availability for this architecture? (Select TWO.)

Create new public and private subnets in a different AZ. Migrate the database to an Amazon RDS multi-AZ deployment.
Create an EC2 Auto Scaling group and Application Load Balancer that spans across multiple AZs.
```

```
A healthcare company is migrating its on-premises Oracle database to an Amazon RDS for Oracle database. The database must meet compliance requirements to retain backups for 120 days. Additionally, the company must have the ability to restore the database to any point in time within the past 10 days. The solution must minimize operational overhead and ensure compliance with these requirements.

Which solution will meet these requirements with the LEAST operational overhead?

Configure Amazon RDS automated backups. Set the retention period to 35 days and enable point-in-time recovery for the past 10 days. Use AWS Backup to retain additional backups for 120 days.