### AWS Security, Identity, & Compliance

```
A financial services company stores transaction records in an Amazon S3 bucket. The company runs its analytics application on a cluster of on-premises servers. The application needs temporary, secure access to the S3 bucket to analyze the data files.

The company uses AWS IAM Identity Center to manage identities and ensure adherence to the principle of least privilege. The solution must avoid long-term credential storage and provide a secure method for the application to access the S3 bucket.

Which solution will meet these requirements?

Use IAM Roles Anywhere to issue temporary credentials to the application. Set up a trust relationship with IAM Identity Center and configure the application to assume the role using these credentials.
```

```
A company runs an application in a private subnet within a VPC. The application is integrated with Amazon Cognito using a user pool for user authentication. The company wants to enable users to securely upload and store their documents in an Amazon S3 bucket.

What combination of steps should the company take to securely integrate the application with Amazon S3? (Select TWO.)

Configure an Amazon Cognito identity pool to provide temporary credentials for Amazon S3 when users authenticate through the user pool.
Enable Amazon S3 VPC endpoints in the VPC to ensure private connectivity between the application and the S3 bucket.
```

```
A company requires that all AWS IAM user accounts have specific complexity requirements and minimum password length.

How should a Solutions Architect accomplish this?

Set a password policy for the entire AWS account.
```

```
A developer created an application that uses Amazon EC2 and an Amazon RDS MySQL database instance. The developer stored the database user name and password in a configuration file on the root EBS volume of the EC2 application instance. A Solutions Architect has been asked to design a more secure solution.

What should the Solutions Architect do to achieve this requirement?

Create an IAM role with permission to access the database. Attach this IAM role to the EC2 instance.
```

```
A healthcare organization is designing a secure web application in the AWS Cloud for managing patient records. The application must securely retrieve and store multiple patient credentials, including access keys and passwords. The organization wants to use an AWS-managed service to handle these credentials. The solution must minimize operational overhead while ensuring security.

Which solution will meet these requirements with the LEAST operational overhead?

Store the patient credentials in AWS Secrets Manager. Use the GetSecretValue API to securely retrieve the credentials in the application at runtime.
```

```
