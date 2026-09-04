### AWS Migration & Transfer

```
A company runs an application in an on-premises data center that collects environmental data from production machinery. The data consists of JSON files stored on network attached storage (NAS) and around 5 TB of data is collected each day. The company must upload this data to Amazon S3 where it can be processed by an analytics application. The data must be transferred securely.

Which solution offers the MOST reliable and time-efficient data transfer?

AWS DataSync over AWS Direct Connect.

The most reliable and time-efficient solution that keeps the data secure is to use AWS DataSync and synchronize the data from the NAS device directly to Amazon S3. This should take place over an AWS Direct Connect connection to ensure reliability, speed, and security.

AWS DataSync can copy data between Network File System (NFS) shares, Server Message Block (SMB) shares, self-managed object storage, AWS Snowcone, Amazon Simple Storage Service (Amazon S3) buckets, Amazon Elastic File System (Amazon EFS) file systems, and Amazon FSx for Windows File Server file systems.
```

```
A surveying team is using a fleet of drones to collect images of construction sites. The surveying team's laptops lack the inbuilt storage and compute capacity to transfer the images and process the data. While the team has Amazon EC2 instances for processing and Amazon S3 buckets for storage, network connectivity is intermittent and unreliable. The images need to be processed to evaluate the progress of each construction site.

What should a solutions architect recommend?

Process and store the images using AWS Snowball Edge devices.

AWS physical Snowball Edge device will provide much more inbuilt compute and storage compared to the current team’s laptops. This negates the need to rely on a stable connection to process any images and solves the team's problems easily and efficiently.
```

```
The database tier of a web application is running on a Windows server on-premises. The database is a Microsoft SQL Server database. The application owner would like to migrate the database to an Amazon RDS instance.

How can the migration be executed with minimal administrative effort and downtime?

Use the AWS Database Migration Service (DMS) to directly migrate the database to RDS

You can directly migrate Microsoft SQL Server from an on-premises server into Amazon RDS using the Microsoft SQL Server database engine. This can be achieved using the native Microsoft SQL Server tools, or using AWS DMS
```

```
A healthcare organization operates multiple applications on virtual machines (VMs) in its on-premises data center. Due to increasing demand for its services, the data center can no longer scale quickly enough to meet business needs. The organization has decided to migrate its non-critical workloads to AWS using a lift-and-shift strategy to expedite the process.

Which combination of steps will meet these requirements? (Select THREE.)

Stop all operations on the VMs. Perform a cutover by launching the migrated instances in AWS.
Use AWS Application Migration Service to replicate the VMs to AWS. Install the AWS Replication Agent on each VM.
Complete the initial data replication from the VMs to AWS. Launch test instances to perform acceptance tests for the workloads.
```

```