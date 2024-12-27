# Database Schema: Posts and Related Details


## MaraiDB Comment 확인
테이블 주석 확인:
```sql
SHOW TABLE STATUS WHERE Name = 'posts';
```

컬럼 주석 확인:
```sql
SHOW FULL COLUMNS FROM posts;
```

## `posts` Table
게시글의 기본 정보를 저장하는 테이블입니다.

```sql
게시글 테이블 (posts)
CREATE TABLE posts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '게시글 고유 ID',
    title VARCHAR(255) NOT NULL COMMENT '게시글 제목',
    content TEXT NOT NULL COMMENT '게시글 내용',
    category ENUM('BOOK', 'PERFORMANCE') NOT NULL COMMENT '게시글 카테고리 (도서 또는 공연)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '게시글 작성 시각',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '게시글 수정 시각'
) COMMENT = '게시글의 기본 정보를 저장하는 테이블';


도서 추가 정보 테이블 (book_details)
CREATE TABLE book_details (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '도서 정보 고유 ID',
    post_id BIGINT NOT NULL COMMENT '연관된 게시글 ID',
    publisher VARCHAR(255) COMMENT '도서 출판사',
    price DECIMAL(10, 2) COMMENT '도서 가격',
    FOREIGN KEY (post_id) REFERENCES posts(id) ON DELETE CASCADE
) COMMENT = '도서와 관련된 추가 정보를 저장하는 테이블';


도서 저자 테이블 (book_authors)
CREATE TABLE book_authors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '저자 정보 고유 ID',
    book_id BIGINT NOT NULL COMMENT '연관된 도서 정보 ID',
    author_name VARCHAR(255) NOT NULL COMMENT '저자 이름',
    FOREIGN KEY (book_id) REFERENCES book_details(id) ON DELETE CASCADE
) COMMENT = '도서의 저자 정보를 저장하는 테이블 (다수의 저자 지원)';


공연 추가 정보 테이블 (performance_details)
CREATE TABLE performance_details (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '공연 정보 고유 ID',
    post_id BIGINT NOT NULL COMMENT '연관된 게시글 ID',
    FOREIGN KEY (post_id) REFERENCES posts(id) ON DELETE CASCADE
) COMMENT = '공연과 관련된 추가 정보를 저장하는 테이블';


공연 장소 테이블 (performance_locations)
CREATE TABLE performance_locations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '공연 장소 고유 ID',
    performance_id BIGINT NOT NULL COMMENT '연관된 공연 정보 ID',
    location_name VARCHAR(255) NOT NULL COMMENT '공연 장소 이름',
    FOREIGN KEY (performance_id) REFERENCES performance_details(id) ON DELETE CASCADE
) COMMENT = '공연의 장소 정보를 저장하는 테이블 (다수의 장소 지원)';


공연 시간 테이블 (performance_times)
CREATE TABLE performance_times (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '공연 시간 고유 ID',
    performance_id BIGINT NOT NULL COMMENT '연관된 공연 정보 ID',
    time DATETIME NOT NULL COMMENT '공연 시작 시간',
    FOREIGN KEY (performance_id) REFERENCES performance_details(id) ON DELETE CASCADE
) COMMENT = '공연의 시간 정보를 저장하는 테이블 (다수의 시간 지원)';


공연 출연진 테이블 (performance_cast)
CREATE TABLE performance_cast (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '출연진 정보 고유 ID',
    performance_id BIGINT NOT NULL COMMENT '연관된 공연 정보 ID',
    cast_name VARCHAR(255) NOT NULL COMMENT '출연진 이름',
    FOREIGN KEY (performance_id) REFERENCES performance_details(id) ON DELETE CASCADE
) COMMENT = '공연의 출연진 정보를 저장하는 테이블';
```