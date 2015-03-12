//
//  main.cpp
//  LRU Cache
//
//  Created by Yanqiao Zhan on 1/6/15.
//  Copyright (c) 2015 Yanqiao Zhan. All rights reserved.
//

#include <iostream>
#include <map>
#include <list>
#include <vector>
#include <unordered_map>
using namespace std;
class LRUCache{
public:
    struct CacheEntry
    {
    public:
        int key;
        int value;
        CacheEntry(int k,int v):key(k),value(v){}
    };
    void movetohead(int key)
    {
        auto updateEntry=*m_map[key];
        m_LRU_cache.erase(m_map[key]);
        m_LRU_cache.push_front(updateEntry);
        m_map[key]=m_LRU_cache.begin();
    }
    LRUCache(int capacity)
    {
        m_capacity=capacity;
    }
    
    int get(int key)
    {
        if(m_map.find(key)==m_map.end())
            return -1;
        movetohead(key);
        return m_map[key]->value;
    }
    void set(int key, int value)
    {
        if(m_map.find(key)==m_map.end())
        {
            CacheEntry newItem(key,value);
            if(m_LRU_cache.size()>=m_capacity)
            {
                m_map.erase(m_LRU_cache.back().key);
                m_LRU_cache.pop_back();
            }
            m_LRU_cache.push_front(newItem);
            m_map[key]=m_LRU_cache.begin();
            return;
        }
        m_map[key]->value=value;
        movetohead(key);
    }
private:
    list<CacheEntry>m_LRU_cache;
    unordered_map<int, list<CacheEntry>::iterator> m_map;
    int m_capacity;
};
int main(int argc, const char * argv[]) {
    LRUCache l(4);
    l.set(1, 100);
        l.set(7, 700);
        l.set(3, 300);
        l.set(4, 400);
        l.set(5, 500);
        l.set(9, 600);
    for(int i=0;i<10;i++)
    cout<<l.get(i)<<endl;
    return 0;
}
