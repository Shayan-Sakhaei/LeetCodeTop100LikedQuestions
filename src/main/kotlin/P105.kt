fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    return buildTree(0, preorder.lastIndex, 0, inorder.lastIndex, preorder, inorder)
}

private fun buildTree(
    preOrderStart: Int, preOrderEnd: Int, inorderStart: Int, inorderEnd: Int, preorder: IntArray, inorder: IntArray
): TreeNode? {
    if (preOrderStart > preOrderEnd || inorderStart > inorderEnd) return null

    val root = TreeNode(preorder[preOrderStart])

    var rootInorderIndex = 0
    for (i in inorderStart..inorderEnd) {
        if (inorder[i] == root.`val`) {
            rootInorderIndex = i
            break
        }
    }

    root.left = buildTree(
        preOrderStart + 1, preOrderEnd, inorderStart, rootInorderIndex - 1, preorder, inorder
    )

    root.right = buildTree(
        preOrderStart + rootInorderIndex - inorderStart + 1,
        preOrderEnd,
        rootInorderIndex + 1,
        inorderEnd,
        preorder,
        inorder
    )

    return root
}
