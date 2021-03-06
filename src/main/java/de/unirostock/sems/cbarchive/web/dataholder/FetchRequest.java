package de.unirostock.sems.cbarchive.web.dataholder;
/*
CombineArchiveWeb - a WebInterface to read/create/write/manipulate/... COMBINE archives
Copyright (C) 2014  SEMS Group

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.unirostock.sems.cbarchive.web.dataholder.Archive.ReplaceStrategy;

// so Jersey parses this as root dataholder, if passed to create or update or something...
@XmlAccessorType(XmlAccessType.FIELD)
public class FetchRequest implements Serializable {

	private static final long serialVersionUID = -2444137273939226465L;
	
	private String path = "/";
	private String remoteUrl = null;
	private String strategy = ReplaceStrategy.RENAME.toString();
	
	public FetchRequest(String path, String remoteUrl) {
		super();
		this.path = path;
		this.remoteUrl = remoteUrl;
	}
	
	public FetchRequest() {
		super();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		if( !path.endsWith("/") )
			path = path + "/";
		this.path = path;
	}
	
	public String getRemoteUrl() {
		return remoteUrl;
	}

	public void setRemoteUrl(String remoteUrl) {
		this.remoteUrl = remoteUrl;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	
	@JsonIgnore
	public boolean isValid() {
		
		if( remoteUrl == null || remoteUrl.isEmpty() )
			return false;
		
		if( path == null || path.isEmpty() )
			return false;
		
		return true;
	}
	
}
