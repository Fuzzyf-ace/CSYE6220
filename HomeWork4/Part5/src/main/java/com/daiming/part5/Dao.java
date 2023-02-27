package com.daiming.part5;

public class Dao {
    final String USERNAME = "admin";
    final String PASSWORD = "NUSRpJQAO7A6z19jGstM";

    final String RDS_ENDPOINT = "csye6220.couxfnqwwltv.us-east-2.rds.amazonaws.com";

    final String URL = "jdbc:mysql://" + RDS_ENDPOINT + ":3306/csye6220?createDatabaseIfNotExist=true&serverTimezone=UTC";
}
