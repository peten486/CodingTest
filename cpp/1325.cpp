#include <stdio.h> /* scanf, printf */
#include <stdlib.h> /* malloc, free */
#include <memory.h> /* memset */
#include <iostream> /* freopen */
#include <vector> /* vector */

using namespace std;

/* input */
/*
5 4
1 2
2 3
3 4
4 1
*/

/* output */
/*
1 2 3 4 
*/

vector<int> result;
int n, m;
int MAX;

void dfs( int v, int *check, vector<int> graph[] );

int main(){

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    scanf("%d %d", &n, &m);

    int *check = (int *)malloc( sizeof(int) * (n+1) );
    vector<int> graph[n+1];
    result.resize(n+1);
    
    for( int i = 0; i < m; i++ ){
        int a, b;
        scanf("%d %d", &a, &b);
        graph[a-1].push_back(b-1);
    }

    MAX = -1;
    for( int i = 0; i < n; i++ ){
        memset( check, 0, (sizeof(int) * (n+1)) );
        dfs( i, check, graph );
    }

    for( int i = 0; i < n; i++ ){
        if( MAX == result.at(i) ){
            printf("%d ", (i+1) );
        }
    }

    free(check);

    return 0;
}

void dfs( int v, int *check, vector<int> 
    graph[] )
{
    check[v] = 1;
    for( int i = 0; i < (int)graph[v].size(); i++ ){
        int temp = graph[v].at(i);
        if( check[temp] == false ){
            result[temp]++;
            if( MAX <= result[temp] ) MAX = result[temp];
            dfs( temp, check, graph );
        }
    }
}

