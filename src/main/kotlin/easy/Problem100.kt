package easy

class Problem100 {
    var res = true

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p?.left != null && q?.left != null) {
            isSameTree(p.left, q.left)
        } else if (!(p?.left == null && q?.left == null)) {
            res = false
        }
        if (p?.`val` != q?.`val`) {
            res = false
        }
        if (p?.right != null && q?.right != null) {
            isSameTree(p.right, q.right)
        } else if (!(p?.right == null && q?.right == null)) {
            res = false
        }
        return res
    }
}