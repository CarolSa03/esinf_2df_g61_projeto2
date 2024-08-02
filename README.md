# Project: Vehicle Energy Dataset Analysis

## Overview

This project involves creating a library of classes, methods, and tests to manage GPS trajectory information related to vehicle trips, fuel consumption, energy use, and speed. The dataset includes static and dynamic data collected from 384 vehicles in Ann Arbor, Michigan, between November 2017 and November 2018.

## Dataset

- **Static Data:** Information about the vehicles (e.g., Vehicle ID, Type, Engine Configuration) is available in `VED_Static_Data_ICE&HEV.xlsx` and `VED_Static_Data_PHEV&EV.xlsx`.
- **Dynamic Data:** Weekly trip records including vehicle parameters and GPS coordinates are in files named `VED_mmddyy_week.csv`, where `mmddyy` represents the starting date of the week.

## Features

1. **Data Loading and Searching:**
   - Load static and dynamic data into BST or AVL trees.
   - Retrieve static vehicle data and dynamic trip details using `VehId`.
   - For a given trip, get all details and the associated vehicle information.

2. **Temporal Analysis:**
   - Calculate the maximum, minimum, and average of parameters such as Vehicle Speed, Absolute Load, and Outside Air Temperature (OAT) for a given vehicle type over a time interval.

3. **Trip Coordinates:**
   - Extract the origin and destination coordinates (Latitude and Longitude) for a given set of trips or trip intervals.

4. **Longest Trip Analysis:**
   - Determine the trip with the greatest straight-line distance between origin and destination for each vehicle identified by `VehId`.

5. **Nearest Trip Search (2D-Tree):**
   - Given two GPS coordinates, find the trip whose origin and destination are closest to the provided coordinates.

6. **Top-N Longest Trips (2D-Tree):**
   - Find the top-N longest trips within a specified geographic area defined by two GPS coordinates.

## Data Structures

- **Binary Search Tree (BST)**
- **Balanced Binary Search Tree (AVL)**
- **2D-Tree**

## Development

- **Language:** Java
- **Version Control:** Git
- **Testing:** Unit tests are implemented to validate the functionality.
- **Reporting:** Includes class diagrams and complexity analysis of algorithms.
