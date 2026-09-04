### AWS Networking & Content Delivery

```
An Amazon S3 bucket in the us-east-1 Region hosts the static website content of a company. The content is made available through an Amazon CloudFront origin pointing to that bucket. A second copy of the bucket is created in the ap-southeast-1 Region using cross-region replication. The chief solutions architect wants a solution that provides greater availability for the website.

Which combination of actions should a solutions architect take to increase availability? (Select TWO.)

Using us-east-1 bucket as the primary bucket and ap-southeast-1 bucket as the secondary bucket, create a CloudFront origin group.
Add an origin for ap-southeast-1 to CloudFront.


You can set up CloudFront with origin failover for scenarios that require high availability. To get started, you create an origin group with two origins: a primary and a secondary. If the primary origin is unavailable or returns specific HTTP response status codes that indicate a failure, CloudFront automatically switches to the secondary origin.
```

```
A company has two accounts for perform testing and each account has a single VPC: VPC-TEST1 and VPC-TEST2. The operations team require a method of securely copying files between Amazon EC2 instances in these VPCs. The connectivity should not have any single points of failure or bandwidth constraints.

Which solution should a Solutions Architect recommend?

Create a VPC peering connection between VPC-TEST1 and VPC-TEST2.

A VPC peering connection is a networking connection between two VPCs that enables you to route traffic between them using private IPv4 addresses or IPv6 addresses. Instances in either VPC can communicate with each other as if they are within the same network.

You can create a VPC peering connection between your own VPCs, or with a VPC in another AWS account. The VPCs can be in different regions (also known as an inter-region VPC peering connection).
```

```
A company has developed a non-production application that is composed of multiple microservices for each of the company's business units. A single development team maintains all the microservices. The current architecture uses a static web frontend and a Java-based backend that contains the application logic. The architecture also uses a MySQL database that the company hosts on an Amazon EC2 instance. The company needs to ensure that the application is secure, scalable, and globally available while minimizing operational overhead.

Which solution will meet these requirements?

Use Amazon CloudFront and Amazon S3 to host the static web frontend. Refactor the backend to use AWS Lambda functions that are invoked by Amazon API Gateway. Migrate the database to Amazon Aurora Serverless for auto-scaling.

S3 and CloudFront provide secure, globally available hosting for the static frontend. AWS Lambda and API Gateway eliminate server management, and Aurora Serverless offers a cost-effective, auto-scaling database solution.
```

```
A company has deployed a new website on Amazon EC2 instances behind an Application Load Balancer (ALB). Amazon Route 53 is used for the DNS service. The company has asked a Solutions Architect to create a backup website with support contact details that users will be directed to automatically if the primary website is down.

How should the Solutions Architect deploy this solution cost-effectively?

Configure a static website using Amazon S3 and create a Route 53 failover routing policy.

The most cost-effective solution is to create a static website using an Amazon S3 bucket and then use a failover routing policy in Amazon Route 53. With a failover routing policy users will be directed to the main website as long as it is responding to health checks successfully.

If the main website fails to respond to health checks (its down), Route 53 will begin to direct users to the backup website running on the Amazon S3 bucket. It’s important to set the TTL on the Route 53 records appropriately to ensure that users resolve the failover address within a short time.
```

```
A genomics research organization is building an application to analyze large datasets. Raw genomic data is stored in an Amazon S3 bucket, processed by multiple Amazon EC2 instances, and the results are stored in a separate S3 bucket. The application frequently transfers large amounts of data between the EC2 instances during analysis. The organization wants to reduce overall data transfer costs while maintaining efficient data processing.

What should the solutions architect do to achieve this?

Deploy all the EC2 instances in the same Availability Zone to eliminate cross-AZ data transfer charges.

data transfer between EC2 instances in the same AZ is free, while transferring data across AZs incurs additional charges. Keeping all instances in the same AZ minimizes data transfer costs while maintaining efficient processing.
```

```
Question 33
Incorrect
A new application is to be published in multiple regions around the world. The Architect needs to ensure only 2 IP addresses need to be whitelisted. The solution should intelligently route traffic for lowest latency and provide fast regional failover.

How can this be achieved?

Launch EC2 instances into multiple regions behind an NLB and use AWS Global Accelerator

AWS Global Accelerator uses the vast, congestion-free AWS global network to route TCP and UDP traffic to a healthy application endpoint in the closest AWS Region to the user.

This means it will intelligently route traffic to the closest point of presence (reducing latency). Seamless failover is ensured as AWS Global Accelerator uses anycast IP address which means the IP does not change when failing over between regions so there are no issues with client caches having incorrect entries that need to expire.
```

```
A global logistics company hosts its shipment tracking system in the eu-west-1 Region. The system runs on Amazon EC2 instances, and customers access the shipment tracking API to retrieve real-time updates about their packages. Customers from Asia and South America report slower API response times compared to customers in Europe.

The company wants to improve API response times for international customers in a cost-effective manner.

Which solution will meet these requirements MOST cost-effectively?

Use AWS Global Accelerator to route traffic through the closest AWS edge location to customers. Configure endpoint groups for the shipment tracking API to distribute traffic globally and reduce response times.

 Global Accelerator uses AWS’s global network to reduce latency by routing traffic through the nearest edge location to the customer. It ensures cost-effective performance improvement for customers in Asia and South America without requiring infrastructure duplication in multiple Regions.
 ```
 
 ```
 A company needs to connect its on-premises data center network to a new virtual private cloud (VPC). There is a symmetrical internet connection of 100 Mbps in the data center network. The data transfer rate for an on-premises application is multiple gigabytes per day. Processing will be done using an Amazon Kinesis Data Firehose stream.

What should a solutions architect recommend for maximum performance?

Kinesis Data Firehose can be connected to the VPC using AWS PrivateLink. Install a 1 Gbps AWS Direct Connect connection between the on-premises network and AWS. To send data from on-premises to Kinesis Data Firehose, use the PrivateLink endpoint.

Amazon Kinesis Data Firehose is an AWS service used to continuously collect streaming data and deliver it to a destination.

Think of it as a pipe that takes data coming in continuously and delivers it somewhere else.
```

```
A company operates a multi-tier application with its backend services deployed on Amazon EC2 instances in a VPC. The backend services must communicate securely with APIs of a third-party SaaS provider that is also hosted on AWS. The company wants to ensure that this communication occurs privately and minimizes exposure to the public internet.

Which solution will meet these requirements?

Configure AWS PrivateLink to create a private connection between the VPC and the third-party SaaS provider's APIs.

AWS PrivateLink enables private connectivity between VPCs and supported AWS or third-party services, ensuring that traffic does not traverse the public internet.
```

```
A company offers an online product brochure that is delivered from a static website running on Amazon S3. The company’s customers are mainly in the United States, Canada, and Mexico. The company is looking to cost-effectively reduce the latency for users in these regions.

What is the most cost-effective solution to these requirements?

Create an Amazon CloudFront distribution and set the price class to use only U.S, Canada and Mexico.

With Amazon CloudFront you can set the price class to determine where in the world the content will be cached. One of the price classes is “U.S, Canada and Mexico” and this is where the company’s users are located. Choosing this price class will result in lower costs and better performance for the company’s users.
```

```
An Amazon VPC contains several Amazon EC2 instances. The instances need to make API calls to Amazon DynamoDB. A solutions architect needs to ensure that the API calls do not traverse the internet.

How can this be accomplished? (Select TWO.)

Create a route table entry for the endpoint
Create a gateway endpoint for DynamoDB

Amazon DynamoDB and Amazon S3 support gateway endpoints, not interface endpoints. With a gateway endpoint you create the endpoint in the VPC, attach a policy allowing access to the service, and then specify the route table to create a route table entry in.
```

```
