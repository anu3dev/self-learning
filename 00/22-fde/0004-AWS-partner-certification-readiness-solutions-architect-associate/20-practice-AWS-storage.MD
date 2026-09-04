### AWS Storage

```
A Microsoft Windows file server farm uses Distributed File System Replication (DFSR) to synchronize data in an on-premises environment. The infrastructure is being migrated to the AWS Cloud.

Which service should the solutions architect use to replace the file server farm?

Amazon FSx

Amazon FSx for Windows file server supports DFS namespaces and DFS replication. This is the best solution for replacing the on-premises infrastructure.
```

```
A company is investigating methods to reduce the expenses associated with on-premises backup infrastructure. The Solutions Architect wants to reduce costs by eliminating the use of physical backup tapes. It is a requirement that existing backup applications and workflows should continue to function.

What should the Solutions Architect recommend?

Connect the backup applications to an AWS Storage Gateway using an iSCSI-virtual tape library (VTL).

The AWS Storage Gateway Tape Gateway enables you to replace using physical tapes on premises with virtual tapes in AWS without changing existing backup workflows. Tape Gateway emulates physical tape libraries, removes the cost and complexity of managing physical tape infrastructure, and provides more durability than physical tapes.
```

```
A company is migrating from an on-premises infrastructure to the AWS Cloud. One of the company's applications stores files on a Windows file server farm that uses Distributed File System Replication (DFSR) to keep data in sync. A solutions architect needs to replace the file server farm.

Which service should the solutions architect use?

Amazon FSx

Amazon FSx for Windows File Server provides fully managed, highly reliable file storage that is accessible over the industry-standard Server Message Block (SMB) protocol.
```

```
A company runs a dynamic website that is hosted on an on-premises server in the United States. The company is expanding to Europe and is investigating how they can optimize the performance of the website for European users. The website’s backed must remain in the United States. The company requires a solution that can be implemented within a few days.

What should a Solutions Architect recommend?

Use Amazon CloudFront with a custom origin pointing to the on-premises servers.

A custom origin can point to an on-premises server and CloudFront is able to cache content for dynamic websites. CloudFront can provide performance optimizations for custom origins even if they are running on on-premises servers. These include persistent TCP connections to the origin, SSL enhancements such as Session tickets and OCSP stapling.

Additionally, connections are routed from the nearest Edge Location to the user across the AWS global network. If the on-premises server is connected via a Direct Connect (DX) link this can further improve performance.
```

```
A company runs an application in a factory that has a small rack of physical compute resources. The application stores data on a network attached storage (NAS) device using the NFS protocol. The company requires a daily offsite backup of the application data.

Which solution can a Solutions Architect recommend to meet this requirement?

Use an AWS Storage Gateway file gateway hardware appliance on premises to replicate the data to Amazon S3.

The AWS Storage Gateway Hardware Appliance is a physical, standalone, validated server configuration for on-premises deployments. It comes pre-loaded with Storage Gateway software, and provides all the required CPU, memory, network, and SSD cache resources for creating and configuring File Gateway, Volume Gateway, or Tape Gateway.
```

```
A video production company is planning to move some of its workloads to the AWS Cloud. The company will require around 5 TB of storage for video processing with the maximum possible I/O performance. They also require over 400 TB of extremely durable storage for storing video files and 800 TB of storage for long-term archival.

Which combinations of services should a Solutions Architect use to meet these requirements?

Amazon EC2 instance store for maximum performance, Amazon S3 for durable data storage, and Amazon S3 Glacier for archival storage.
```

```
A global manufacturing company uses AWS Outposts servers to manage IoT workloads in its factories across multiple continents. The company regularly updates factory IoT software, consisting of 50 files, from a central Amazon S3 bucket in the us-east-1 Region. Factories report significant delays when downloading and applying the updates, causing downtime. The company needs to minimize the latency for distributing software updates globally while reducing operational overhead.

Which solution will meet this requirement with the LEAST operational overhead?

Create an Amazon S3 bucket in the us-east-1 Region. Set up an Amazon CloudFront distribution with the S3 bucket as the origin. Use signed URLs to download the software updates.

CloudFront caches the software updates at edge locations around the world, significantly reducing latency. Signed URLs ensure secure access, and the solution requires minimal operational overhead.
```

```
A scientific research institute stores experimental datasets in AWS. Some datasets are accessed daily for analysis, while others remain unused for weeks or months. The datasets are large and must be highly durable, but the institute wants to reduce costs without compromising availability for frequently accessed data.

The institute needs a cost-effective storage solution that adapts to these varying access patterns and ensures the highest durability.

Which storage solution meets these requirements?

Use Amazon S3 Intelligent-Tiering to automatically adjust storage costs based on the frequency of data access while maintaining high durability.
```

```
A company is deploying a fleet of Amazon EC2 instances running Linux across multiple Availability Zones within an AWS Region. The application requires a data storage solution that can be accessed by all of the EC2 instances simultaneously. The solution must be highly scalable and easy to implement. The storage must be mounted using the NFS protocol.

Which solution meets these requirements?

Create an Amazon EFS file system with mount targets in each Availability Zone. Configure the application instances to mount the file system.

Amazon EFS provides scalable file storage for use with Amazon EC2. You can use an EFS file system as a common data source for workloads and applications running on multiple instances. The EC2 instances can run in multiple AZs within a Region and the NFS protocol is used to mount the file system.

With EFS you can create mount targets in each AZ for lower latency. The application instances in each AZ will mount the file system using the local mount target.
```