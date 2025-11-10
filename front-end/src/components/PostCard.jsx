export default function PostCard({ post }) {
    return (
        <div className="card border-light text-bg-light mb-3" style={{ maxWidth: "580px" }}>
            <div className="row g-0">
                <div className="col-md-4">
                    <img src={post.imagePath} className="img-fluid rounded-start" />
                </div>
                <div className="col-md-8">
                    <div className="card-body">
                        <span>{post.user.username}</span>
                        <h5 className="card-title">{post.title}</h5>
                        <p className="card-text"><small className="text-body-secondary">Last updated 3 mins ago</small></p>
                        <div className="d-flex gap-2 text-light">
                            <span className="bg-info p-0 rounded-2 d-flex align-items-center gap-1 flex-shrink-1">
                                <button className="btn btn-info rounded-2 px-2"><i class="bi bi-arrow-up-circle text-light"></i></button>
                                <span className="mx-1">{post.score}</span>
                                <button className="btn btn-info rounded-2 px-2"><i class="bi bi-arrow-down-circle text-light"></i></button>
                            </span>
                            <span className="btn btn-info rounded-2 d-flex align-items-center gap-1 flex-shrink-1 text-light">
                                <i class="bi bi-chat text-light"></i>
                                {post.commentsCount}
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}