package com.jejen.test.laundry.system.sftp.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SFTPBean {
	
	private JSch mJSchSession = null;
	private Session mSSHSession = null;
	private ChannelSftp mChannelSftp = null;
	
	static ChannelSftp channelSftp;
	
	public boolean connect(String strHostAddress, int iPort, String strUsername, String strPassword){
		boolean blResult = false;
		
		try {
			
			String privateKey = "";
			//creating a new jsch session
			this.mJSchSession = new JSch();
			
			//set sftp server no check key when login 
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			this.mJSchSession.setConfig(config);
			this.mJSchSession.addIdentity(privateKey);
			//creating session with us	er, host port
			this.mSSHSession = mJSchSession.getSession(strUsername, strHostAddress, iPort);
			
			//set password
			this.mSSHSession.setPassword(strPassword);
			
			
			//connect
			this.mSSHSession.connect();
			this.mChannelSftp = (ChannelSftp) this.mSSHSession.openChannel("sftp");
			this.mChannelSftp.connect();
			if(this.mChannelSftp != null){
				blResult = true;
			} 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return blResult;
		
	}
	
	//list file on sftp server
	public Vector<LsEntry> listFile(String strPath){
		Vector<LsEntry> vtFile = null;
		
		try {
			vtFile = this.mChannelSftp.ls(strPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vtFile;
	}
	
	//download file from sftp
    public boolean downloadFile(String strSftpFile, String strLocalFile){
    	boolean blResult = false;
    	
    	try {
    		System.out.println("one dest: "+strLocalFile);
    		System.out.println("one src: "+strSftpFile);
			this.mChannelSftp.get(strSftpFile, strLocalFile);
			blResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return blResult;
    }
    
    @SuppressWarnings("unchecked")
     public boolean recursiveFolderDownload(String sourcePath, String destinationPath) throws SftpException {
		
		Vector<LsEntry> fileAndFolderList = null;
		fileAndFolderList = this.mChannelSftp.ls(sourcePath);
        String PATHSEPARATOR = "/";
        
        //Iterate through list of folder content
        for (ChannelSftp.LsEntry item : fileAndFolderList) {
            
            if (!item.getAttrs().isDir()) { // Check if it is a file (not a directory).
                if (!(new File(destinationPath + PATHSEPARATOR + item.getFilename())).exists()
                        || (item.getAttrs().getMTime() > Long
                                .valueOf(new File(destinationPath + PATHSEPARATOR + item.getFilename()).lastModified()
                                        / (long) 1000)
                                .intValue())) { // Download only if changed later.

                   // new File(destinationPath + PATHSEPARATOR + item.getFilename());
                    String src = sourcePath + item.getFilename();
                    String dest = destinationPath;
                    System.out.println("New file: "+item.getFilename());
                    this.mChannelSftp.get(src, dest); // Download file from source (source filename, destination filename).
                }
            } else if (!(".".equals(item.getFilename()) || "..".equals(item.getFilename()))) {
                new File(destinationPath + PATHSEPARATOR + item.getFilename()).mkdirs(); // Empty folder copy.
                recursiveFolderDownload(sourcePath + PATHSEPARATOR + item.getFilename(),
                        destinationPath + PATHSEPARATOR + item.getFilename()); // Enter found folder on server to read its contents and create locally.
            }
        }
        return true;
    }

    
    
    //upload file to sftp
    public boolean uploadFile(String strLocalFile, String StrSftpFile){
    	boolean blResult= false;
    	
    	try {
			this.mChannelSftp.put(strLocalFile, StrSftpFile);
			blResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return blResult;
    }
	
    public void close(){
    	
    	//close channel
    	try {
    		this.mChannelSftp.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	//close connection
    	try {
			this.mSSHSession.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    
    
    @SuppressWarnings("unchecked")
    public List<String> recursiveGetOutgoingFilename(String sourcePath) throws SftpException {
    	List<String> listFilename = new ArrayList<String>();
    	
		Vector<LsEntry> fileAndFolderList = null;
		fileAndFolderList = this.mChannelSftp.ls(sourcePath);
       
       //Iterate through list of folder content
       for (ChannelSftp.LsEntry item : fileAndFolderList) {
           
    	   listFilename.add(item.getFilename()); 
       }
       return listFilename;
   }

    
}
