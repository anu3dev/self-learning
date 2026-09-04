### AWS Analytics

```
A genetics research firm processes DNA sequencing data for multiple clients. The raw data is stored in relational databases provided by each client. The company must extract the data, apply unique transformation algorithms for each client, and store the processed results in Amazon S3.

Due to the sensitivity of the data, the company must encrypt it both during processing and at rest in Amazon S3. Each client must have their own encryption keys to meet compliance requirements. The company also wants to minimize operational overhead while implementing this solution.

Which solution will meet these requirements with the LEAST operational effort?

Use AWS Glue to create individual ETL jobs for each client. Attach a security configuration that uses client-specific AWS KMS keys for server-side encryption (SSE-KMS) during processing and storage in S3.


AWS Glue simplifies ETL workflows and supports attaching security configurations to enforce client-specific encryption with KMS keys. This approach minimizes operational effort by automating the process while meeting encryption requirements.
```

```
A research organization wants to set up an Amazon EMR cluster for multiple departments to run their big data analytics jobs. The organization needs to ensure that each department’s workloads can access only the specific AWS services required for their analysis. Additionally, the organization wants to block access to Instance Metadata Service Version 2 (IMDSv2) on the EMR cluster's underlying EC2 instances.

Which solution will meet these requirements?


Use EMR runtime roles to enforce granular permissions for each department's workloads. Configure the EMR cluster to use these roles when submitting jobs.


EMR runtime roles allow fine-grained access control for individual workloads without exposing permissions at the instance level. Runtime roles are scoped specifically to applications, reducing the risk of unnecessary access.
```

```
A company provides a REST-based interface to an application that allows a partner company to send data in near-real time. The application then processes the data that is received and stores it for later analysis. The application runs on Amazon EC2 instances.

The partner company has received many 503 Service Unavailable Errors when sending data to the application and the compute capacity reaches its limits and is unable to process requests when spikes in data volume occur.

Which design should a Solutions Architect implement to improve scalability?

Use Amazon Kinesis Data Streams to ingest the data. Process the data using AWS Lambda functions.

Amazon Kinesis enables you to ingest, buffer, and process streaming data in real-time. Kinesis can handle any amount of streaming data and process data from hundreds of thousands of sources with very low latencies. This is an ideal solution for data ingestion.

To ensure the compute layer can scale to process increasing workloads, the EC2 instances should be replaced by AWS Lambda functions. Lambda can scale seamlessly by running multiple executions in parallel.
```

```
A retail company with many stores and warehouses is implementing IoT sensors to gather monitoring data from devices in each location. The data will be sent to AWS in real time. A solutions architect must provide a solution for ensuring events are received in order for each device and ensure that data is saved for future processing.

Which solution would be MOST efficient?

Use Amazon Kinesis Data Streams for real-time events with a partition key for each device. Use Amazon Kinesis Data Firehose to save data to Amazon S3


Amazon Kinesis Data Streams collect and process data in real time. A Kinesis data stream is a set of shards. Each shard has a sequence of data records. Each data record has a sequence number that is assigned by Kinesis Data Streams. A shard is a uniquely identified sequence of data records in a stream.

A partition key is used to group data by shard within a stream. Kinesis Data Streams segregates the data records belonging to a stream into multiple shards. It uses the partition key that is associated with each data record to determine which shard a given data record belongs to.
```