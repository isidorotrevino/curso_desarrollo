package com.ies.curso.spring.tema06.ejemplo04.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubUser {

	protected String login;
	protected Long id;
	protected String node_id;
	protected String avatar_url;
	protected String gravatar_id;
	protected String url;
	protected String html_url;
	protected String followers_url;
	protected String following_url;
	protected String gists_url;
	protected String starred_url;
	protected String subscriptions_url;
	protected String organizations_url;
	protected String repos_url;
	protected String events_url;
	protected String received_events_url;
	protected String type;
	protected String site_admin;
	protected String name;
	protected String company;
	protected String blog;
	protected String location;
	protected String email;
	protected String hireable;
	protected String bio;
	protected String public_repos;
	protected String public_gists;
	protected String followers;
	protected String following;
	protected String created_at;
	protected String updated_at;
}
