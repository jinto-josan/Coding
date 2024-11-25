# Coding

Practicing competitive programming

## Learning

  - [ ] Basics
    - [x] Space Time Complexity Analysis
        1. *Online judge O(N) is 10^8 iteration*
        2. *For each iteration T(N)= how much time then sum all T(N), T(N/2)...*
        3. *Some useful formulas :- *
            <p>
                Linear sum - N+(N-1)+(N-2)...0 = N(N+1)/2
                Geometric sum - ar + ar<sup>2</sup> +ar<sup>3</sup>..+a/r<sup>k</sup> = a(|1- r<sup>k</sup>|)/(|1-r|) . And for infinite it is a/(1-r)
            </p>
        4. *Example Merge sort:-*
            <p>  
                T(N) = K(for terminal condition)+ KN(to merge) + T(N/2) + T(N/2) = (K+1)N + 2T(N/2) = cN + 2T(N/2)
                T(N/2) = c(N/2) + 2T(N/4) -> 2T(N/2) = cN + 4T(N/4) (Multiplied so that it cancels right hand 2T(N/2) of previous equation when we sum.
                T(N/4) = c(N/4) + 2T(N/8)
                ... this will continue and reach as T(1) = cN + 0
                T(N)= sum<sub>i=1</sub>(cN)<sup>i=log<sub>2</sub>N</sup> = NlogN
            </p>           
    - [x] STL
        - [x] Containers (All stl containers are pass by value.)
                | Sequence | Assoicative | UnorderedAssociative | Adaptors|
                |----------|-------------|----------------------|---------|
                |Array     |Set          |Unordered Set         |Stack    |
                |Vector    |Map          |Unordered Map         |Queue    |
                |Deque     |MultiSet     |Un Multi(Dupli)set    |PrtyQ(Hp)|
                |ForwardLst|MiltiMap     |Unordered MultiMap    |         |
                |List      |             |                      |         |
        - [ ] Creating, intializing and [implementing above structures](linkwillbethere)
        - [ ] [Problems](linkswillbehere)
    - [ ] Data Structures
    - [ ] Bitmanipulation Basics
    - [ ] Bitmanipulation Problems
  - [ ] Mathematics
    - [ ] Big Integers
    - [ ] Linear Recurrences & Matrix Exponentiation
    - [ ] Pigeonhole Principle
    - [ ] Mathematical Expectation
    - [ ] Inclusion-Exclusion
  - [ ] Number Theory
    - [ ] Prime Numbers & Factorisation 
    - [ ] Extended Euclidean Algorithm
    - [ ] Theorems in Number Theory
    - [ ] Combinatorics
  - [ ] Algorithms
    - [ ] Recursion
    - [ ] Backtracking
    - [ ] Binary Search
    - [ ] Divide & Conquer
    - [ ] Greedy Algorithms
    - [ ] Meet in Middle
  - [ ] Range Queries
    - [ ] Segment Trees
    - [ ] Lazy Propagation
    - [ ] Fenwick Trees
    - [ ] Square Root Decomposition
  - [ ] Game Theory
    - [ ] Combinatorial Games
    - [ ] NIM Game
  - [ ] Graph Theory
    - [ ] Graph Traversals
    - [ ] Graphs as Trees
    - [ ] Lowest Common Ancestor
    - [ ] Directed Graphs & SCC
    - [ ] Disjoint Set Union
    - [ ] Spanning Trees
    - [ ] Shortest Paths
  - [ ] Dynamic Programming
    - [ ] Classical DP
    - [ ] Advanced DP
  - [ ] Pattern Matching
    - [ ] Pattern & String Matching
  - [ ] Advanced Topics
    - [ ] Geometric Algorithms
    - [ ] Interactive Problems
    - [ ] Random Randomisation
    - [ ] Policy Based Data Structures