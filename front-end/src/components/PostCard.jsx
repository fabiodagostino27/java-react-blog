export default function PostCard({ post }) {
    return (
        <div className="card mb-3" style={{ maxWidth: "580px" }}>
            <div className="row g-0">
                <div className="col-md-4">
                    <img src={post.imagePath} className="img-fluid rounded-start" />
                </div>
                <div className="col-md-8">
                    <div className="card-body">
                        <span>{post.user.username}</span>
                        <h5 className="card-title">{post.title}</h5>
                        <p className="card-text"><small className="text-body-secondary">Last updated 3 mins ago</small></p>
                        <span className="btn btn-primary align-middle">
                            <i class="bi bi-arrow-up-circle"></i>
                            {post.score}
                            <i class="bi bi-arrow-down-circle"></i>
                        </span>
                        <span className="btn btn-primary align-middle">
                            <i class="bi bi-chat-left"></i>
                            {post.commentsCount}
                        </span>
                    </div>
                </div>
            </div>
        </div>
    )
}