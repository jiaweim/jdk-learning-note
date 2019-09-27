# NIO 和 IO 的主要差别



# Path
`Path` 类支持两类操作：语法操作（文件路径操作）和文件操作（通过路径操作文件）。

# FileSystem

|方法|说明|
|---|---|
|FileSystems.getDefault()|返回默认的`FileSystem`|
|FileSystems.getFileSystem(URI uri)|返回满足指定URI的 file system|