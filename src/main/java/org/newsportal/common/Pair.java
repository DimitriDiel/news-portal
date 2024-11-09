package org.newsportal.common;

import lombok.Getter;

@Getter
public class Pair<T, U> {
private final T first;
private final U second;

public Pair(T first, U second)
{
        this.first = first;
        this.second = second;
}
}