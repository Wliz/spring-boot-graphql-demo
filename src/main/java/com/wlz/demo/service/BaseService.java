package com.wlz.demo.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

/**
 * @author wlz
 * @date 9/12/18 14:42
 */
public interface BaseService extends GraphQLQueryResolver, GraphQLMutationResolver {}
