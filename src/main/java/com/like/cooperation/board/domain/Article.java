package com.like.cooperation.board.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.core.jpa.domain.AbstractAuditEntity;

/**
 * <p>게시글 클래스</p>
 * 
 * [상세내용] <br>
 *   1. <br>
 * [제약조건] <br>
 *   1. <br>
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "GRWARTICLE")
@EntityListeners(AuditingEntityListener.class)
public class Article extends AbstractAuditEntity {		
	
	/**
	 * 게시글 키
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ARTICLE_ID")
	Long articleId;	
		
	@Comment("게시글 부모ID")
	@Column(name="ARTICLE_P_ID")
	Long articleParentId;		
				
	@Embedded
	ArticleContents content;
	
	@Comment("조회 수")
	@Column(name="HIT_CNT")
    int hitCount;
	
	@Comment("출력순서")
	@Column(name="SEQ")
    Integer seq;
        
	@Comment("계층 레벨")
	@Column(name="HIER_DEPTH")
    int depth;			
	
	@Column(name="FIXED_TOP_YN")
	boolean isFixedTop;
	
	@Embedded
	ArticlePassword password;
    
	/**
	 * 게시판 외래키
	 */           
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOARD_ID", nullable=false, updatable=false)
	Board board;
    	                          
    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    List<ArticleAttachedFile> files;
			
	@Formula("(SELECT X.USER_NAME FROM COMUSER X WHERE X.USER_ID = CREATED_USER_ID)")
	String userName;
			
	@Transient
	Boolean editable;
		
	public Article(Board board
			      ,ArticleContents content
			      ,ArticlePassword password
				  ,List<ArticleAttachedFile> files) {
		
		if (board == null) throw new IllegalArgumentException("게시판이 존재하지 않습니다.");
		
		this.board = board;
		this.content = content;
		this.password = password;
		this.files = files;
				
	}
	
	public void modifyEntity(ArticleContents content
							,boolean isFiexedTop) {
		this.content = content;				
		this.isFixedTop = isFiexedTop;
	}
	
	public Long getId() {
		return this.articleId;
	}
				
	public void setBoard(Board board) {
		this.board = board;
		
		if (!board.getArticles().contains(this)) {
			board.getArticles().add(this);
		}
	}
	
	public boolean hasParentArticle() {		
		return this.articleParentId != this.articleId ? true : false;
	}
						
	public void updateHitCnt() {
		this.hitCount = this.hitCount + 1;	
	}	
		
	public List<ArticleAttachedFile> getAttachedFileInfoList() {
		if (this.files == null) this.files = new ArrayList<>();
		
		return this.files;				  		 					 
	}
	
	public List<String> getFileIds() {
		if (this.files == null) return Collections.emptyList();
		
		return this.files.stream().map(e -> e.getFileInfo().toString()).toList();
	}
	
	public void setFiles(List<ArticleAttachedFile> files) {
		this.files = files;
	}
	
	public Boolean getEditable(String userId) {			
		return this.getCreatedBy() == null ? false : this.getCreatedBy().getLoggedUser().equals(userId);
	}	
			
}